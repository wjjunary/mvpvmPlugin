package temp.presenter


import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import org.jdesktop.swingx.util.Contract
import temp.module.YrycModuleRecipe;


/**
 * 输入的数据
 */
val yrycPresenterTemplateData
    get() = template {
        revision = 1
        name = "YRYC Presenter"
        description = "适用于一人一车框架的模板代码，快速生成Presenter请求"
        minApi = MIN_API
        minBuildApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

        val moduleName = stringParameter {
            name = "类名"
            default = ""
            help = "输入Presenter类名，首字母无需大写，无需输入Presenter"
            constraints = listOf(Constraint.NONEMPTY)
        }

        val packageName = defaultPackageNameParameter
        widgets(
                TextFieldWidget(moduleName),
                PackageNameWidget(packageName)
        )

        recipe = { data: TemplateData ->
            YrycPresenterRecipe(
                    data as ModuleTemplateData,
                    moduleName.value,
                    packageName.value)
        }
    }


val defaultPackageNameParameter
    get() = stringParameter {
        name = "上级包名"
        visible = { !isNewModule }
        default = "com.yryc.onecar"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }