docker run alpine echo "Hello, world!"

docker run -it alpine echo "Hello, world!"

docker run -it alpine sh


docker build -t my-nginx-image .

docker run -d -p 80:80 my-nginx-image
