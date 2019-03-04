# runthecode

Docker to run command 
docker build -f Dockerfile -t runtheworld .


docker run -d -p 33060:3306 --name runthecode -e MYSQL_ROOT_PASSWORD=admin adminuser


docker run -d -p 33060:3306 --name mysql-db -e MYSQL_ROOT_PASSWORD=secret mysql

docker run --name mysql-db --link some-mysql:mysql -d runthecode

D:\workspaces\Spring\runthecode>docker run -d -p 33060:3306 --name mysql-db -e MYSQL_ROOT_PASSWORD=secret mysql
Unable to find image 'mysql:latest' locally
latest: Pulling from library/mysql
6ae821421a7d: Pull complete
a9e976e3aa6d: Pull complete
e3735e44a020: Pull complete
bfd564e9483f: Pull complete
df705f26e488: Pull complete
0c5547f73d62: Pull complete
f437382cf8a1: Pull complete
b8e2d50f1513: Pull complete
e2e3c9928180: Pull complete
b60db6d282cd: Pull complete
1d32deab69c6: Pull complete
408a40cd2e9c: Pull complete
Digest: sha256:a571337738c9205427c80748e165eca88edc5a1157f8b8d545fa127fc3e29269
Status: Downloaded newer image for mysql:latest
38e83f003dd4570d8565a20866d39f75d947850e25b3d5445475508c0e96a3bc