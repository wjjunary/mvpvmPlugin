package temp

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import temp.activity.YrycActivityData
import temp.module.yrycModuleTemplateData
import temp.presenter.yrycPresenterTemplateData

/**
 *
 * author : wangjunjun
 * date   : 2021/9/22
 * desc   :
 */
class PluginTemplateProviderImpl : WizardTemplateProvider() {

    override fun getTemplates(): List<Template> = listOf(
            yrycModuleTemplateData,
            YrycActivityData
    )
}