package temp.activity

/**
 *
 * author : wangjunjun
 * date   : 2021/9/22
 * desc   :
 */
class YrycActivityViewModelProvider(
        val activityName: String,
        val activityType: ActivityEnum,
        val isDef :Boolean,
        val packageName: String
) {

    var baseViewModelPath = "com.yryc.onecar.databinding.viewmodel.BaseActivityViewModel"
    var baseViewModel = "BaseActivityViewModel"

    init {
        when (activityType) {
            ActivityEnum.BaseDataBindingActivity -> {
                baseViewModelPath = "com.yryc.onecar.databinding.viewmodel.BaseActivityViewModel"
                baseViewModel = "BaseActivityViewModel"
            }
            ActivityEnum.BaseContentActivity -> {
                baseViewModelPath = "com.yryc.onecar.databinding.viewmodel.BaseContentViewModel"
                baseViewModel = "BaseContentViewModel"
            }
            ActivityEnum.BaseListViewActivity -> {
                baseViewModelPath = "com.yryc.onecar.databinding.viewmodel.BaseActivityViewModel"
                baseViewModel = "BaseActivityViewModel"
            }
            ActivityEnum.BaseSearchActivity -> {
                baseViewModelPath = "com.yryc.onecar.databinding.viewmodel.SearchViewModel"
                baseViewModel = "SearchViewModel"
            }
            ActivityEnum.BaseSearchListActivity -> {
                baseViewModelPath = "com.yryc.onecar.databinding.viewmodel.SearchViewModel"
                baseViewModel = "SearchViewModel"
            }
        }
    }

    fun getViewModel(): String {
        return """
package ${packageName}.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import $baseViewModelPath;

/**
 * 
 */
public class ${activityName}ViewModel extends $baseViewModel {

}
        """
    }

    fun getViewModelName(): String {
        return if (isDef) {
            baseViewModel
        } else {
            "${activityName}ViewModel"
        }
    }

    fun getViewModelPath(): String {
        return if (isDef) {
            baseViewModelPath
        } else {
            "${packageName}.ui.viewmodel.${activityName}ViewModel"
        }
    }
}