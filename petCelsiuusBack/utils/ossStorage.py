import oss2
import random
import string
from django.core.files.storage import Storage

# 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
# 获取的AccessKey,和AccessKey Secret
auth = oss2.Auth('LTAI5tMMRUVcNmfWrM5RjUyX', 'Fchr5xqVXddeT869ptwf6TfthZ9tOE')
# 这个是需要用特定的地址，不同地域的服务器地址不同，不要弄错了
endpoint = 'oss-cn-chengdu.aliyuncs.com'
# 你的项目名称，类似于不同的项目上传的图片前缀url不同
# 因为我用的是ajax传到后端方法接受的是b字节文件，需要如下配置。 阿里云oss支持更多的方式，下面有链接可以自己根据自己的需求去写
bucket = oss2.Bucket(auth, endpoint, 'greatmall')  # bucket名称


# Bucket 域名
ALI_BASE_URL = 'https://greatmall.oss-cn-chengdu.aliyuncs.com/'
BUCKET_NAME = "greatmall"

# 这个是上传图片后阿里云返回的uri需要拼接下面这个url才可以访问，根据自己情况去写这步
# ALI_BASE_URL = 'https://lalala.oss-cn-beijing.aliyuncs.com/'


def random_string():
    return ''.join(random.choice(string.ascii_uppercase) for i in range(16)) + ".jpg"


def storage(file):
    """
    ！ 上传单张图片
    :param file: b字节文件
    :return: 若成功返回图片路径，若不成功返回空
    """
    # 生成文件名 上传到制定路径文件夹
    file_name = "petApi/" + random_string()
    # 上传到制定路径文件

    # res = bucket.put_object(文件名, 文件数据)
    res = bucket.put_object(file_name, file)
    # 如果上传状态是200 代表成功 返回文件外网访问路径
    # 下面代码根据自己的需求写
    if res.status == 200:
        # return file_link
        return ALI_BASE_URL + file_name
    else:
        return False



class MyStorage(Storage):
    """自定义文件存储类"""

    def _open(self, name, mode='rb'):
        pass

    def _save(self, name, content, max_length=None):
        pass

    def exists(self, name):
        pass

    def url(self, name):
        # name 就是图片的名字，
        return ALI_BASE_URL + name


if __name__ == '__main__':
    with open("C:\\Users\\liqisong\\Pictures\\Saved Pictures\\唱首民谣吧jpg.jpg", "rb") as pf:
        content = pf.read()
        result = storage(content)
        print(result)