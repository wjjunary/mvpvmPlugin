package temp.module


import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import temp.module.YrycModuleRecipe;


/**
 * 输入的数据
 */
val yrycModuleTemplateData
    get() = template {
        revision = 1
        name = "YRYC Module"
        description = "适用于一人一车框架的模板代码，快速生成di、presenter、ui等包"
        minApi = MIN_API
        minBuildApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

        val packName = stringParameter {
            name = "包名"
            default = ""
            help = "输入报名"
            constraints = listOf(Constraint.NONEMPTY)
        }

        val isCustomer = booleanParameter {
            name = "是否是车主端"
            default = true
        }

        val hadBean = booleanParameter {
            name = "是否包含Bean包"
            default = true
        }

        val hadModel = booleanParameter {
            name = "是否包含Model包"
            default = true
        }

        val packageName = defaultPackageNameParameter
        widgets(
                TextFieldWidget(packName),
                CheckBoxWidget(hadBean),
                CheckBoxWidget(hadModel),
                CheckBoxWidget(isCustomer),
                PackageNameWidget(packageName)
        )

        recipe = { data: TemplateData ->
            YrycModuleRecipe(
                    data as ModuleTemplateData,
                    packName.value,
                    isCustomer.value,
                    hadBean.value,
                    hadModel.value,
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