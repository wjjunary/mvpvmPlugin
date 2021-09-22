package temp.presenter

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor

/**
 *
 * author : wangjunjun
 * date   : 2021/9/22
 * desc   :
 */
fun RecipeExecutor.YrycPresenterRecipe(
        moduleData: ModuleTemplateData,
        name: String,
        packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
    val className = getClassName(name)

    val provider = YrycPresenterProvider(packageName, name)

    val contractFile = srcOut.resolve("contract")
    save(provider.getContract(), contractFile.resolve("I${className}Contract.${ktOrJavaExt}"))
    save(provider.getPresenter(), srcOut.resolve("${className}Presenter.${ktOrJavaExt}"))

}

fun getClassName(name: String) = name.substring(0, 1).toUpperCase() + name.substring(1)

