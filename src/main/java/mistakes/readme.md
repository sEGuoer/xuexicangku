## 各种错误

### 1.查询代码中大括号是否多了或少了
![img.png](img.png)


### 2.赋值在使用类方法之后导致对应的参数为null
![img_1.png](img_1.png)
调试时可以先把后一段删掉，然后只检查前半段是否能正常运行(6.7)<p>
出错位置[xuehao1.java](..%2FD20230607%2Fxuehao1.java)

### 3.主类错误
查看同文件下的文件名，字符串相同但是不同大小写会影响，要将其中一个类改成不同名的
字符串
![img_3.png](img_3.png)

### 4.递归要有终止条件（不然占满stack）
![img_2.png](img_2.png)