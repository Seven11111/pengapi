# 小白接口

小白接口是一个提供 API 接口供开发者调用的平台。
用户可以注册登录，开通接口调用权限。用户可以浏览接口并调用，且每次调用会进行统计。
管理员可以发布接口、下线接口、接入接口，以及可视化接口的调用情况、数据。



## 技术栈

**前端：**

- ESLint + Prettier
- TypeScript
- Ant Design Pro
-  Ant Design、Echarts

**后端：**

- SpringBoot 2.7.x
- MybatisPlus
- SpringCloud Gateway
- Dubbo、Nacos

- knife4j

## 项目组成

小白接口是一个前后端联调的Web项目，由前端和后端两部分组成。



### 前端：pengapi-frontend模块

前端是用 Ant Design Pro 脚手架快速搭建基础页面，并对原始模板进行瘦身、抽象为可复用的公共模板，便于后续同类项目的快速研发。

在脚手架自带的 umi-request 请求库基础上进行改造和封装，添加全局请求拦截和全局异常处理逻辑、自动根据项目启动命令来区分环境，减少重复代码、提升项目可维护性。

使用 ECharts（或 AntV）可视化库实现了接口调用的分析图表（如饼图），并通过 loading 配置提高加载体验。

使用 ESLint + Prettier + TypeScript + Husky 等技术保证前端项目质量。



### 后端：pengapi-backend模块

后端由四个子模块组成：

- pengapi-client-sdk：供开发者快速调用接口的sdk
- pengapi-common：抽取的公共实体类和service方法
- pengapi-gateway：网关，接口调用时进行统一路由转发、鉴权、跨域等功能的实现
- pengapi-interface：接口项目，实现具体的接口逻辑



## 项目截图



![image.png](https://cdn.nlark.com/yuque/0/2024/png/38933574/1709105255747-2c3469f4-c741-471d-9423-dea7be12d9e4.png?x-oss-process=image%2Fresize%2Cw_1125%2Climit_0)



![image.png](https://cdn.nlark.com/yuque/0/2024/png/38933574/1709105274394-aaea49fa-f4c5-4ae1-b0e7-066b24c75c46.png?x-oss-process=image%2Fresize%2Cw_1125%2Climit_0)

﻿



![image.png](https://cdn.nlark.com/yuque/0/2024/png/38933574/1709105290777-88386e52-73c4-4a1b-ae3d-8765477ab047.png?x-oss-process=image%2Fresize%2Cw_1125%2Climit_0)

﻿

﻿



![image.png](https://cdn.nlark.com/yuque/0/2024/png/38933574/1709105309891-5aa9cf7c-5882-4e52-9b82-02854b2e3aac.png?x-oss-process=image%2Fresize%2Cw_1125%2Climit_0)

﻿









