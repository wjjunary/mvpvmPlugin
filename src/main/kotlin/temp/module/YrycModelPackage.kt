package temp.module


class YrycModelPackage(
        packageName: String,
        name: String) {
    val packageName = "$packageName.$name"
    var moduleName = name

    init {
        moduleName = name.substring(0, 1).toUpperCase() + name.substring(1)
    }

    fun getApi() = """
package ${packageName}.model;

import java.util.Map;
import java.util.List;
import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 
 */
public interface I${moduleName}Api {
    
}
    """

    fun getRetrofit() = """
package ${packageName}.model;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.Body;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.yryc.onecar.core.base.BaseResponse;
import com.yryc.onecar.core.base.BaseRetrofit;

public class ${moduleName}Retrofit extends BaseRetrofit {
    
    private I${moduleName}Api api;
    
    public ${moduleName}Retrofit(I${moduleName}Api api) {
        this.api = api;
    }
}
    """

}



