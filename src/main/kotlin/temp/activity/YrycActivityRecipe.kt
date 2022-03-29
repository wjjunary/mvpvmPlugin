package temp.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import temp.presenter.YrycPresenterProvider

/**
 *
 * author : wangjunjun
 * date   : 2021/9/22
 * desc   :
 */
fun RecipeExecutor.YrycActivityRecipe(
        moduleData: ModuleTemplateData,
        activityName: String,
        activityType: ActivityEnum,
        hadViewModel: Boolean,
        isCommonLayout: Boolean,
        layoutName: String,
        packageName: String) {

    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
    val className = getClassName(activityName)

    //包名
    val uiFile = srcOut.resolve("ui")

    //ViewModel
    val viewModelProvider = YrycActivityViewModelProvider(className, activityType, !hadViewModel, packageName)
    if (hadViewModel) {
        save(viewModelProvider.getViewModel(), uiFile.resolve("viewmodel").resolve("${className}ViewModel.java"))
    }

    //布局文件
    val layoutProvider = YrycActivityLayoutProvider(layoutName, viewModelProvider.getViewModelPath(), isCommonLayout, activityType, packageName)
    if (!isCommonLayout) {
        val xmlFile = resOut.resolve("layouts").resolve("activity").resolve("layout").resolve("${layoutName}.xml")
        save(layoutProvider.getLayoutXml(), xmlFile)
    }

    //Presenter
    val provider = YrycPresenterProvider(packageName, activityName)
    val presenterFile = srcOut.resolve("presenter")
    save(provider.getContract(), presenterFile.resolve("contract").resolve("I${className}Contract.java"))
    save(provider.getPresenter(), presenterFile.resolve("${className}Presenter.java"))

    //对应的Activity
    val activityProvider = YrycActivityProvider(className, activityType, viewModelProvider, layoutProvider, packageName, projectData.applicationPackage)
    val activityFile = uiFile.resolve("activity").resolve("${className}Activity.java")
    save(activityProvider.getActivity(), activityFile)

    open(activityFile)
    open(moduleData.manifestDir)
}


fun getClassName(name: String) = name.substring(0, 1).toUpperCase() + name.substring(1)