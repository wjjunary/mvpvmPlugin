package temp.module

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor

/**
 *
 * author : wangjunjun
 * date   : 2021/9/22
 * desc   :
 */
fun RecipeExecutor.YrycModuleRecipe(
        moduleData: ModuleTemplateData,
        name: String,
        isCustomer: Boolean,
        hadBean: Boolean,
        hadModel: Boolean,
        packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
    val className = getClassName(name)

    //包名
    val packFile = srcOut.resolve(name)
    //先创建包
    createDirectory(packFile)

    //创建bean包
    if (hadBean) {
        val beanFile = packFile.resolve("bean")
        createDirectory(beanFile)
        createDirectory(beanFile.resolve("enums"))
        createDirectory(beanFile.resolve("req"))
        createDirectory(beanFile.resolve("res"))
        createDirectory(beanFile.resolve("bean"))
    }

    //创建model包
    if (hadModel) {
        val modelFile = packFile.resolve("model")
        createDirectory(modelFile)
        val modelProvider = YrycModelPackage(packageName, name)
        save(modelProvider.getApi(), modelFile.resolve("I${className}Api.${ktOrJavaExt}"))
        save(modelProvider.getRetrofit(), modelFile.resolve("${className}Retrofit.${ktOrJavaExt}"))
    }

    //创建di包
    val diFile = packFile.resolve("di")
    createDirectory(diFile)
    val diProvider = YrycDiPackage(packageName, name, isCustomer)
    val moduleFile = diFile.resolve("module")
    createDirectory(moduleFile)
    save(diProvider.getModule(), moduleFile.resolve("${className}Module.${ktOrJavaExt}"))
    val componentFile = diFile.resolve("component")
    createDirectory(componentFile)
    save(diProvider.getComponent(), componentFile.resolve("${className}Component.${ktOrJavaExt}"))


    //创建presenter包
    val presenterFile = packFile.resolve("presenter")
    createDirectory(presenterFile)
    createDirectory(presenterFile.resolve("contract"))

    //创建ui包
    val uiFile = packFile.resolve("ui")
    createDirectory(uiFile)
    createDirectory(uiFile.resolve("activity"))
    createDirectory(uiFile.resolve("fragment"))
    createDirectory(uiFile.resolve("viewmodel"))
    createDirectory(uiFile.resolve("window"))

}

fun getClassName(name: String) = name.substring(0, 1).toUpperCase() + name.substring(1)

