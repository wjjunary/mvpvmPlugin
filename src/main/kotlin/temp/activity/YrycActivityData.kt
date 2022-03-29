package temp.activity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API

/**
 *
 * author : wangjunjun
 * date   : 2021/9/22
 * desc   :
 */

val YrycActivityData
    get() = template {
        revision = 1
        name = "YRYC Activity"
        description = "适用于一人一车框架的模板代码，快速生成Activity模板"
        minApi = MIN_API
        minBuildApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

        val activityName = stringParameter {
            name = "Activity 名字"
            default = ""
            help = "请输入Activity名称，首字母无需大写，无需输入Activity"
            constraints = listOf(Constraint.NONEMPTY)
        }

        val activityType = enumParameter<ActivityEnum> {
            name = "Activity基类"
            default = ActivityEnum.BaseDataBindingActivity
        }

        val hadViewModel = booleanParameter {
            name = "是否创建对应的ViewModel"
            default = false

        }

        val isCommonLayout = booleanParameter {
            name = "是否使用通用布局"
            default = false
            visible = {
                activityType.value == ActivityEnum.BaseListViewActivity
                        || activityType.value == ActivityEnum.BaseSearchListActivity
            }
        }

        var layoutName = stringParameter {
            name = "Layout Name"
            default = ""
            help = "请输入布局的名字"
            visible = { !isCommonLayout.visible || !isCommonLayout.value }
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { activityToLayout(activityName.value) }
        }


        val packageName = defaultPackageNameParameter

        widgets(
                TextFieldWidget(activityName),
                EnumWidget<ActivityEnum>(activityType),
                CheckBoxWidget(hadViewModel),
                CheckBoxWidget(isCommonLayout),
                TextFieldWidget(layoutName),
                PackageNameWidget(packageName)
        )

        recipe = { data: TemplateData ->
            YrycActivityRecipe(
                    data as ModuleTemplateData,
                    activityName.value,
                    activityType.value,
                    hadViewModel.value,
                    isCommonLayout.value,
                    layoutName.value,
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
val RFilePath
    get() = stringParameter {
        name = "上级包名"
        visible = { !isNewModule }
        default = "com.yryc.onecar"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }