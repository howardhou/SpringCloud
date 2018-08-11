# SpringCloud


## ISSUE
- warning: push.default is unset; its implicit value is changing in Git 2.0 from 'matching' to 'simple'
	- Git2.0以后: git config --global push.default simple   , [设置默认行为为simple](https://blog.csdn.net/u010828718/article/details/51161802)
    - Git2.0以前: git config --global push.default matching  

- [让git push命令不再每次都输入密码](https://blog.csdn.net/itmyhome1990/article/details/42557817)
	- Github获取远程库时，有ssh方式和https方式
	- 使用ssh 方式
		- git remote rm origin
		- git remote add origin git@github.com:howardhou/SpringCloud.git

	- 使用https 方式 ： 参见： http://www.cnblogs.com/zhonghuasong/p/5975952.html
	 	- cd ~
		- touch .git-credentials
		- vim .git-credentials
		- https://{username}:{password}@github.com
		- git config --global credential.helper store
		- 修改 ~/.gitconfig 文件 

- [Connecting to GitHub with SSH](https://help.github.com/articles/connecting-to-github-with-ssh/)
	- [Generating a new SSH key](https://help.github.com/articles/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent/)
		- ssh-keygen -t rsa -b 4096 -C "21689620@qq.com"
	- A[dding a new SSH key to your GitHub account](https://help.github.com/articles/adding-a-new-ssh-key-to-your-github-account/)
		- 复制ssh public key : pbcopy < ~/.ssh/id_rsa.pub
	- [Testing your SSH connection](https://help.github.com/articles/testing-your-ssh-connection/)
		- ssh -T git@github.com


