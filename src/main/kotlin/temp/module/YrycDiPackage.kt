package temp.module


class YrycDiPackage(
        packageName: String,
        name: String,
        val isCustomer: Boolean) {

    val packageName = "$packageName.$name"

    var basePackagePath = ""
    var moduleName = name

    init {
        if (isCustomer) {
            basePackagePath = "com.yryc.onecar.lib.base"
        } else {
            basePackagePath = "com.yryc.onecar.base"
        }
        moduleName = name.substring(0, 1).toUpperCase() + name.substring(1)
    }

    fun getModule() = """
package ${packageName}.di.module;
import dagger.Module;


@Module
public class ${moduleName}Module {
    
    public ${moduleName}Module() {
    }
}
    """

    fun getComponent() = """
        
package ${packageName}.di.component;
import ${basePackagePath}.di.scope.RetrofitScope;
import ${basePackagePath}.di.scope.UIScope;
import ${basePackagePath}.di.component.AppComponent;
import ${basePackagePath}.di.module.DialogModule;
import ${basePackagePath}.di.module.UiModule;
import dagger.Component;
import ${packageName}.di.module.${moduleName}Module;


@RetrofitScope
@UIScope
@Component(dependencies = AppComponent.class, modules = {UiModule.class, ${moduleName}Module.class, DialogModule.class})
public class ${moduleName}Component {
    
    public ${moduleName}Component() {
    }
}
    """

}



