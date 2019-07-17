#!/usr/bin/env bash
mvn clean
mvn package -Dmaven.test.skip=true
scp '/home/htg/work/project/sirui_store/store-user/target/store-user-1.0-SNAPSHOT.jar' root@101.132.42.189:~/htg/temp/
scp '/home/htg/work/project/sirui_store/store-sms/target/store-sms-1.0-SNAPSHOT.jar' root@101.132.42.189:~/htg/temp/
scp '/home/htg/work/project/sirui_store/store-good/target/store-good-1.0-SNAPSHOT.jar' root@101.132.42.189:~/htg/temp/
scp '/home/htg/work/project/sirui_store/store-file-service/target/store-file-service-1.0-SNAPSHOT.jar' root@101.132.42.189:~/htg/temp/
scp '/home/htg/work/project/sirui_store/store-common/target/store-common-1.0.0.jar' root@101.132.42.189:~/htg/temp/
scp '/home/htg/work/project/sirui_store/store-client-feign/target/store-client-feign-1.0-SNAPSHOT.jar' root@101.132.42.189:~/htg/temp/
scp '/home/htg/work/project/sirui_store/shop-registry/target/shop-registry-1.0-SNAPSHOT.jar' root@101.132.42.189:~/htg/temp/
scp '/home/htg/work/project/sirui_store/store-auth/target/store-auth-1.0-SNAPSHOT.jar' root@101.132.42.189:~/htg/temp/



nohup java -jar store-user-1.0-SNAPSHOT.jar >user_temp.log &
nohup java -jar store-sms-1.0-SNAPSHOT.jar >sms_temp.log &
nohup java -jar store-good-1.0-SNAPSHOT.jar >good_temp.log &
nohup java -jar store-file-service-1.0-SNAPSHOT.jar >file_temp.log &
nohup java -jar shop-registry-1.0-SNAPSHOT.jar >registry_temp.log &
nohup java -jar store-auth-1.0-SNAPSHOT.jar >auth_temp.log &