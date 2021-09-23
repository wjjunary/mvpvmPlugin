package temp.activity

/**
 *
 * author : wangjunjun
 * date   : 2021/9/22
 * desc   :
 */
class YrycActivityLayoutProvider(
        val layoutName: String,
        val viewModel: String,
        val isCommon: Boolean,
        val activityType: ActivityEnum,
        val packageName: String
) {

    fun getLayoutXml(): String {
        when (activityType) {
            ActivityEnum.BaseDataBindingActivity -> {
                return """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    
    <data>
        <variable
            name="viewModel"
            type="${viewModel}" />

        <variable
            name="listener"
            type="com.yryc.onecar.databinding.listener.BaseActivityListener" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/white"
        android:orientation="vertical">

        <include
            android:id="@+id/toolbar"
            layout="@layout/common_title_bar_white"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:listener="@{listener}"
            app:viewModel="@{viewModel}" />

    </LinearLayout>
</layout>
                """
            }
            ActivityEnum.BaseContentActivity -> {
                return """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    
    <data>
        <variable
            name="viewModel"
            type="${viewModel}" />

        <variable
            name="listener"
            type="com.yryc.onecar.databinding.listener.BaseActivityListener" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/white"
        android:orientation="vertical">

    </LinearLayout>
</layout>
                """
            }
            ActivityEnum.BaseListViewActivity -> {

                return """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <variable
            name="viewModel"
            type="${viewModel}" />

        <variable
            name="listener"
            type="com.yryc.onecar.databinding.listener.BaseActivityListener" />

        <variable
            name="listViewModel"
            type="com.yryc.onecar.databinding.viewmodel.BaseListActivityViewModel" />

        <variable
            name="listListener"
            type="com.yryc.onecar.databinding.listener.IListViewListener" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/white"
        android:orientation="vertical">

        <include
            android:id="@+id/toolbar"
            layout="@layout/common_title_bar_white"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:listener="@{listener}"
            app:viewModel="@{viewModel}" />

        <include
            android:id="@+id/list"
            layout="@layout/layout_refresh_list"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:listener="@{listListener}"
            app:viewModel="@{listViewModel.commListViewModel}" />

    </LinearLayout>
</layout>
                """
            }
            ActivityEnum.BaseSearchActivity -> {
                return """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    
    <data>
        <variable
            name="viewModel"
            type="${viewModel}" />

        <variable
            name="listener"
            type="com.yryc.onecar.databinding.ui.BaseSearchActivity" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/white"
        android:orientation="vertical">

        <include
            android:id="@+id/toolbar"
            layout="@layout/common_title_bar_white"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:listener="@{listener}"
            app:viewModel="@{viewModel}" />

        <include
            android:id="@+id/search_bar"
            layout="@layout/layout_search_bar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:listener="@{listener}"
            app:viewModel="@{viewModel}" />

    </LinearLayout>
</layout>
                """
            }
            ActivityEnum.BaseSearchListActivity -> {
                return """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    
    <data>
        <variable
            name="viewModel"
            type="${viewModel}" />

        <variable
            name="listener"
            type="com.yryc.onecar.databinding.listener.BaseSearchActivityListener" />
        <variable
            name="listViewModel"
            type="com.yryc.onecar.databinding.viewmodel.BaseListActivityViewModel" />

        <variable
            name="listListener"
            type="com.yryc.onecar.databinding.listener.IListViewListener" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/white"
        android:orientation="vertical">

        <include
            android:id="@+id/toolbar"
            layout="@layout/common_title_bar_white"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:listener="@{listener}"
            app:viewModel="@{viewModel}" />

        <include
            layout="@layout/layout_search_bar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:listener="@{listener}"
            app:viewModel="@{viewModel}" />


        <include
            android:id="@+id/list"
            layout="@layout/layout_refresh_list"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:listener="@{listListener}"
            app:viewModel="@{listViewModel.commListViewModel}" />
    </LinearLayout>
</layout>
                """
            }
        }

        return ""
    }

    fun getLayoutFileName(): String {
        if (isCommon) {
            when (activityType) {
                ActivityEnum.BaseListViewActivity -> {
                    return "activity_common_list"
                }
                ActivityEnum.BaseSearchListActivity -> {
                    return "activity_common_search_list"
                }
            }
        }
        return layoutName
    }
}