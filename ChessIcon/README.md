### Automation script to deploy PCF on vSphere

#### Steps to deploy PCF:

#### Prerequisite
**VMware OVF Tool for Linux 64-bit** :      
>> Version : 4.2.0           
>> Build Number: 5965791              

download ovftool from  https://www.vmware.com/support/developer/ovf/ as it required to create vmware account.        
$ bash VMware-ovftool-4.2.0-5965791-lin.x86_64.bundle

#### 1. Edit the configuration in inventory file <br/>
$ vim inventory.ini

> ##### i. update Ops Manager ansible_ssh_user=ubuntu, ansible_ssh_pass=vmware, ansible_sudo_pass=vmware

> ##### ii. update jump vm (from where ansible script will start) sudo pass

> ##### iii. vCenter configurations
>> a. Configure vcenter_ip (e.g. ‘10.102.1.150’) with the IP of the vCenter.         
>> b. Configure vcenter_user (e.g. 'Administrator@vsphere.local’) and vcenter_password (e.g. 'vmware’) with vCenter user name and password.        
>> c. Configure network_name (e.g. 'pivotal0|default|pcf-system’) with the name of the vSphere network.        
>> d. Configure vcenter_dc (e.g. 'cf-DC’) with the name of the datacenter the Director will use for VM creation.      
>> e. Configure vcenter_ds (e.g. 'datastore2’)       
>> f. Configure vcenter_cluster (e.g. 'pivotal-cluster’) with the name of the vSphere cluster.                   
>> g. Configure gateway, cidr, netmask, dns, ntp_servers & admin_password, to launch Ops Manager using ovftool command                         

> ##### iv. Ops manager configurations
>> a. Update Ops Manager version, API download Link, ops_manager_SHA256, if you want different version [Pivotal Network](https://network.pivotal.io/)       
>> b. Update Ops Manager IP, username, password and decryption_passphrase          
>> c. Update Ops Manager UI IP (Proxy IP that redirect UI traffic to Ops Manager IP)                
        
> ##### v. Configure Proxy
>> a. Configure http_proxy, https_proxy and no_proxy for proxy server <br/>  
>> Note:<br/> If you are using the same proxy to handle both HTTPS and HTTP traffic, enter the same URL as HTTP proxy and HTTPS proxy.<br/> No proxy- Enter the following IP addresses as no proxy: 
>>  - 127.0.0.1
>>  - The IP of Ops Manager 
>>  - The IP address of your BOSH Director. This is the first IP address next to Ops Manager IP address. If Ops Manager IP is 10.11.0.2 then BOSH Director IP will be 10.11.0.3             
>> **Note: The values in the No Proxy field must be comma-delimited, with no spaces or quotation marks between values. Example: 127.0.0.1,10.11.0.2,10.11.0.3**                

> ##### vi. Elastic runtime configurations
>> a. Update elastic runtime version, API download link and pcf_elastic_runtime_SHA256, if you want different version [Pivotal Network](https://network.pivotal.io/)        
>> b. Update haproxy static ip (entry point for CF)           
>> c. update apps_domain and system_domain        

> ##### vii. PCF Isolation Segment configurations
>> a. isolation_segment flag (default: True) to deploy PCF with isolation-segments     
>> b. Update isolation segment version, API download link and pcf_isolation_segment_SHA256, if you want different version [Pivotal Network](https://network.pivotal.io/)                
>> c. isolation segment name must be unique across the entire system     
>> d. isolation segment network configurations                 

#### 2. Deploy PCF <br/>
$ ansible-playbook deploy_ops_manager.yml -i inventory.ini                
**Note: PCF deploy will take around 3 Hours**

> **To see verbose output**
>> $ ansible-playbook deploy_ops_manager.yml -i inventory.ini -vvvv           

> **To enable ansible logging**     
>> $ ANSIBLE_LOG_PATH=./ansible.log
>> $ ansible-playbook deploy_ops_manager.yml -i inventory.ini -vvvv       

> **To cleanup PCF deployment**   
>> $ ansible-playbook pcf_cloud_foundry_cleanup.yml -i inventory.ini            

#### 3. After successfully deployment of Pivotal CloudFoundry : <br/>          
$ source pcf_bosh

#### 4. To see running instances <br/>
$ bosh vms                       

**You are now ready to deploy your first app!**           
 
#### 5. Deploy to Cloud Foundry (Hello World) <br/>
$ git clone https://github.com/vchrisb/cf-helloworld /root/workspace/cf-helloworld          
$ cd /root/workspace/cf-helloworld             
$ cf push             

**You should now be able to access the app locally**                   

#### 6. To see app status <br/>
$ cf apps       
$ curl http://cf-helloworld.<system-domain\>           

