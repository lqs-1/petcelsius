## petcelsius项目结构

---
- 小程序提供数据的api项目`petCelsiusApi`
- 小程序项目`petCelsiusUniapp`
- 小程序业务后台项目`petCelsiuusBack`
- 目前保存在数据库中的数据`petcelsius.sql`
- 文档readme.md

## 项目部署

---
### 1、先下载项目(没有安装git的去git官网下载)
```html
git clone https://gitee.com/lqs2002/pet-celsius-api.git
```

### 2、部署api项目`petCelsiusApi`
#### 开发环境
> - idea开发工具
> - jdk8
#### 部署
> 搭建好环境之后用idea打开项目等待即可

### 3、部署小程序项目`petCelsiusUniapp`
#### 开发环境
> - 微信开发者工具（微信官网去找）
> - HBuilderX（百度它的官网下载）
> - 在微信官网申请自己的appid（申请方式自行百度）

#### 部署
- 扫码登录微信开发者工具，扫码的微信就是去官网申请过appid的微信
- 打开HBuilderX绑定好微信开发者工具，具体可以百度"`HBuilderX配置微信小程序开发`"
- 利用HBuilderX打开项目，启动方式一键运行到小程序模拟器，去百度就好，如果编译过程中出现报错，比如某个包不存在，可以点击他的提升进行下载获取去百度对应的包进行下载

### 4、部署小程序业务后台项目`petCelsiuusBack`
#### 开发环境
> - python3(随便那个版本，最好是3.8)
> - pycharm开发工具

#### 部署
> 用pycharm打开项目，并且找到pycharm下面的Terminal点开，复制以下命令到控制台，然后回车
```text
    pip install django  &&
    pip install pymysql  &&
    pip install django-tinymce  &&
    pip install Pillow  &&
    pip install django-cors-headers
```
> 安装oss

`pip install django-aliyun-oss2-storage   然后修改backends.py下面的force_text为force_str`

> 启动项目在Terminal模式下cd到manage.py所在的目录
```python
python manage.py runserver 或者 python3 manage.py runserver
```

### 5、数据库
> 创建一个名叫petcelsius的数据库，自己百度将petcelsius.sql中的数据导入数据库