#Generate the SSH Key
ssh-keygen -t rsa -C "test@gmail.com" -q -P "" -f "/home/vagrant/.ssh/id_rsa"

cat /home/vagrant/.ssh/id_rsa > /home/vagrant/private.key
cat /home/vagrant/.ssh/id_rsa.pub > /home/vagrant/public.key

