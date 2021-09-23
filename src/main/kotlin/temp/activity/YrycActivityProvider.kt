package temp.activity

/**
 *
 * author : wangjunjun
 * date   : 2021/9/22
 * desc   :
 */
class YrycActivityProvider(
        val activityName: String,
        val activityType: ActivityEnum,
        val viewModel: YrycActivityViewModelProvider,
        val layout: YrycActivityLayoutProvider,
        val packageName: String,
        val applicationPackage: String?
) {

    fun getActivity(): String {
        when (activityType) {
            ActivityEnum.BaseDataBindingActivity -> {
                return """
package ${packageName}.ui.activity;

import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import ${applicationPackage}.R;
import ${viewModel.getViewModelPath()};
import ${packageName}.presenter.${activityName}Presenter;
import ${packageName}.presenter.contract.I${activityName}Contract;
import androidx.databinding.ViewDataBinding;
import com.yryc.onecar.databinding.ui.BaseDataBindingActivity;

/**
 * 
 */
@Route(path = )
public class ${activityName}Activity extends BaseDataBindingActivity<ViewDataBinding, ${viewModel.getViewModelName()}, ${activityName}Presenter> 
        implements I${activityName}Contract.IView {

    @Override
    public int getLayoutId() {
        return R.layout.${layout.getLayoutFileName()};
    }

    @Override
    protected void inject() {
    }
    
    @Override
    protected void initContent() {
//        setTitle();
    }

    @Override
    protected void initData() {
    }
    
    @Override
    public void onClick(View view) {
    }
}
                """
            }
            ActivityEnum.BaseContentActivity -> {
                return """
package ${packageName}.ui.activity;

import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import ${applicationPackage}.R;
import ${viewModel.getViewModelPath()};
import ${packageName}.presenter.${activityName}Presenter;
import ${packageName}.presenter.contract.I${activityName}Contract;
import com.yryc.onecar.databinding.ui.BaseContentActivity;

/**
 * 
 */
@Route(path = )
public class ${activityName}Activity extends BaseContentActivity<${viewModel.getViewModelName()}, ${activityName}Presenter> 
        implements I${activityName}Contract.IView {

    @Override
    public int getContentId() {
        return R.layout.${layout.getLayoutFileName()};
    }

    @Override
    protected void inject() {
    }
    
    @Override
    protected void initContent() {
//        setTitle();
    }

    @Override
    protected void initData() {
    }
    
    @Override
    public void onClick(View view) {
    }
}
                """
            }
            ActivityEnum.BaseListViewActivity -> {
                return """
package ${packageName}.ui.activity;

import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.yryc.onecar.databinding.viewmodel.BaseViewModel;
import ${applicationPackage}.R;
import ${viewModel.getViewModelPath()};
import ${packageName}.presenter.${activityName}Presenter;
import ${packageName}.presenter.contract.I${activityName}Contract;
import androidx.databinding.ViewDataBinding;
import com.yryc.onecar.databinding.ui.BaseListViewActivity;

/**
 * 
 */
@Route(path = )
public class ${activityName}Activity extends BaseListViewActivity<ViewDataBinding, ${viewModel.getViewModelName()}, ${activityName}Presenter> 
        implements I${activityName}Contract.IView {

    @Override
    public int getLayoutId() {
        return R.layout.${layout.getLayoutFileName()};
    }

    @Override
    protected void inject() {
    }
    
    @Override
    protected void initContent() {
//        setTitle();
//        setEnableLoadMore(true);
//        setEnableRefresh(true);
//        setEmpty(ListViewProxy.EmptyIcon.Car, "暂无数据");
    }

    @Override
    protected void initData() {
        super.initData();
    }
    
    @Override
    public void fetchData(int pageNum, int pageSize, boolean isInit, Object param) {
    }
    
    @Override
    public void onItemClick(View view, BaseViewModel viewModel) {
    }
    
    @Override
    public void onClick(View view) {
    }
    
}
                """
            }
            ActivityEnum.BaseSearchActivity -> {
                return """
package ${packageName}.ui.activity;

import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import ${applicationPackage}.R;
import ${viewModel.getViewModelPath()};
import ${packageName}.presenter.${activityName}Presenter;
import ${packageName}.presenter.contract.I${activityName}Contract;
import androidx.databinding.ViewDataBinding;
import com.yryc.onecar.databinding.ui.BaseSearchActivity;

/**
 * 
 */
@Route(path = )
public class ${activityName}Activity extends BaseSearchActivity<ViewDataBinding, ${viewModel.getViewModelName()}, ${activityName}Presenter> 
        implements I${activityName}Contract.IView {

    @Override
    public int getLayoutId() {
        return R.layout.${layout.getLayoutFileName()};
    }

    @Override
    protected void inject() {
    }
    
    @Override
    protected void initContent() {
//        setTitle();
    }

    @Override
    protected void initData() {
    }
    
    @Override
    public void searchData(String search) {
    }
    
    @Override
    public void onClick(View view) {
    }
}
                """
            }
            ActivityEnum.BaseSearchListActivity -> {
                return """
package ${packageName}.ui.activity;

import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.yryc.onecar.databinding.viewmodel.BaseViewModel;
import ${applicationPackage}.R;
import ${viewModel.getViewModelPath()};
import ${packageName}.presenter.${activityName}Presenter;
import ${packageName}.presenter.contract.I${activityName}Contract;
import androidx.databinding.ViewDataBinding;
import com.yryc.onecar.databinding.ui.BaseSearchListActivity;

/**
 * 
 */
@Route(path = )
public class ${activityName}Activity extends BaseSearchListActivity<ViewDataBinding, ${viewModel.getViewModelName()}, ${activityName}Presenter> 
        implements I${activityName}Contract.IView {

    @Override
    public int getLayoutId() {
        return R.layout.${layout.getLayoutFileName()};
    }

    @Override
    protected void inject() {
    }
    
    @Override
    protected void initContent() {
//        setTitle();
//        setEnableLoadMore(true);
//        setEnableRefresh(true);
//        setEmpty(ListViewProxy.EmptyIcon.Car, "暂无数据");
    }

    @Override
    protected void initData() {
        super.initData();
    }
    
    @Override
    public void searchData(int pageNum, int pageSize, String search) {
    }
    
    @Override
    public void onItemClick(View view, BaseViewModel viewModel) {
    }
    
    @Override
    public void onClick(View view) {
    }
    
}
                """
            }
        }
        return ""
    }
}