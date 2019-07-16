package com.example.hardtaskvideo.Interface;

public interface TaskDetailContract {//使用契约类来统一管理view与presenter的所有的接口，这种方式
    // 使得view与presenter中有哪些功能，一目了然，维护起来也很方便

    interface View extends LoginBaseView<Presenter> {
        // 设置数据加载状态
        void setLoadingIndicator(boolean active);
        // 处理task加载失败的情况
        void showMissingTask();
        // 隐藏待办事项title
        void hideTitle();
        // 显示待办事项title
        void showTitle(String title);
        // 隐藏待办事项的描述
        void hideDescription();
        // 显示待办事项的描述
        void showDescription(String description);

    }

    interface Presenter extends LoginBasePresenter {
        // 修改待办事项
        void editTask();
        // 删除待办事项
        void deleteTask();
        // 标记完成
        void completeTask();
        // 标记未完成
        void activateTask();
    }
}
