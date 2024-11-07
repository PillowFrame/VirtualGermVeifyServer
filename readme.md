# 萌芽引擎虚拟验证服务器
此项目仅供交流学习验证原理，请勿用于非法用途，可用于二次开发无需授权
## 效果图
![验证成功效果图](./pic/console-client.png)
![验证成功效果图](./pic/console-server.png)

## 兼容版本
理论4.4.1以前都兼容，后续版本只要萌芽引擎不改验证协议都会兼容

## 使用方法
1. 修改host verify.germmc.com为验证服务器地址
2. ``java -jar VirtualGermVerifyServer-1.0-SNAPSHOT.jar``

## 注意事项
1. 验证服务器防火墙注意放行29976 tcp端口