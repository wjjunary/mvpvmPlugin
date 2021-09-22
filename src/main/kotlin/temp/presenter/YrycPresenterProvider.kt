package temp.presenter


class YrycPresenterProvider(
        packageName: String,
        name: String,) {

    val packageName = "$packageName.$name"

    var moduleName = name

    init {
        moduleName = name.substring(0, 1).toUpperCase() + name.substring(1)
    }

    fun getPresenter() = """
package ${packageName}.presenter;

import com.yryc.onecar.core.rx.RxPresenter;
import com.yryc.onecar.core.rx.RxThrowableConsumer;
import com.yryc.onecar.core.rx.RxUtils;
import ${packageName}.presenter.contract.I${moduleName}Contract;
import javax.inject.Inject;
import io.reactivex.rxjava3.functions.Consumer;


public class ${moduleName}Presenter extends RxPresenter<I${moduleName}Contract.IView> implements I${moduleName}Contract.IPresenter  {
    
    
    @Inject
    public ${moduleName}Presenter( ) {
    }
}
    """

    fun getContract() = """
        
package ${packageName}.presenter.contract;

import com.yryc.onecar.core.base.IBaseView;

public interface I${moduleName}Contract {
    
    interface IView extends IBaseView {
    
    }

    interface IPresenter {
    
    }
}
    """

}



