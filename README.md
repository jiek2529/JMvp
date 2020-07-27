# MVP架构

使用Presenter 持有 IBaseView 与 IBaseModel

构建 Presenter 在 Activity中，由 Presenter 触发获取数据 fechData(),让 Model 去网络取数据。

IBaseView 提供 getData 抽象方法，由 IBaseModel的请求结果回调此方法，供。

你使 Activity 的代码简洁清晰。
