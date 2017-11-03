### Automation script to deploy CF on vSphere

#### Steps to deploy CF:

#### 1. Edit the configuration in inventory file
$ vim inventory.ini

> ##### i. Update inventory.ini with specific details about vCenter, Director IP, internal DNS & Proxy-Server

> ##### ii. Update ansible_sudo_pass, password of vm from where ansible script will start

> ##### iii. BOSH CLI v2     
>> a. update bosh_cli_release and bosh_cli_sha1 for latest BOSH release       

> ##### iv. vCenter configurations           
>> a. Configure vcenter_ip (e.g. ‘10.102.1.150’) with the IP of the vCenter.        
>> b. Configure vcenter_user (e.g. 'Administrator@vsphere.local’) and vcenter_password (e.g. 'vmware’) with vCenter user name and password.        
>> c. Configure vcenter_dc (e.g. 'cf-DC’) with the name of the datacenter the Director will use for VM creation.      
>> d. Configure vcenter_vms (e.g. 'bosh-1-vms’) and TEMPLATES-FOLDER-NAME (e.g. 'bosh-1-templates’) with the name of the folder created to hold VMs and the name of the folder created to hold stemcells.             
>> e. Configure vcenter_ds (e.g. 'datastore1|datastore1_1’)       
>> f. Configure vcenter_disks (e.g. 'bosh-1-disks’) with the name of the VMs folder.        
>> g. Configure vcenter_cluster (e.g. 'cf-cluster’) with the name of the vSphere cluster.        
>> h. Configure network_name (e.g. 'cf0|default|cf-system’) with the name of the vSphere network.        
 
> ##### v.  BOSH Director configurations              
>> a. Configure internal_ip, internal_gw and internal_cidr (Director vm's IP address and CIDR to configures CF vms)          
>> b. Configure system_domain (system domain for CF)           
>> c. Configure router_static_ip (assign router vm static ip address)         
>> d. Configure internal_dns               

> ##### vi.  isolation-segments (is) configurations        
>> a. isolation_segment flag (default: True) to deploy CF with isolation-segments     
>> b. isolation segment name must be unique across the entire system     
>> c. isolation segment network configurations     

> ##### vii. cf git repo releases            
>> a. Update cf_deployment, cf_networking_release and cf cli releases to latest version        

> ##### viii.  Proxy server config.
>> a. Configure http_proxy, https_proxy and no_proxy       

> ##### ix. For app to app communication through proxy        
>> a. Set app_proxy_communication flag to True for app to app communication through proxy-server otherwise False        

> ##### x.  Configure CNI flag
>> a. Set default_cni flag to True, if you want to configured CF with default SILK CNI, otherwise False for Cisco's ACI add-ons                  


**Note: For Cisco's ACI add-ons**
1. Download the release tarball to jump VM from https://drive.google.com/open?id=0B882PS8bAm_9M0tSazJQMnhrTlk , file aci-containers-release-0.0.3.tgz            
2. Copy it into cloud-foundry-automation/scripts/cf_ansible
3. Update cloud-foundry-automation/operations/cloud-vars.yml with the following values:
> - apic_dvs: vmware0
> - apic_infra_portgroup: apic-infra
4. Update cloud-foundry-automation/operations/cf-vars.yml with ACI-specific deployment variables


#### 2. To deploy CF using BOSH CLI v2         
$ ansible-playbook deploy_bosh_director.yml -i inventory.ini <br /> **Note: CF deploy will take around 2 Hours**

> **To see verbose output**
>> $ ansible-playbook deploy_bosh_director.yml -i inventory.ini -vvvv           

> **To enable ansible logging**     
>> $ ANSIBLE_LOG_PATH=./ansible.log <br /> $ ansible-playbook deploy_bosh_director.yml -i inventory.ini -vvvv       

> **To cleanup CF deployment**   
>> $ ansible-playbook bosh_cleanup.yml -i inventory.ini

### After successfully deployment of CloudFoundry :   

#### 3. source CF BOSH Environments
$ source cf_bosh                                  

#### 4. status of bosh           
$ bosh env      

#### 5. To see running instances
$ bosh vms         

### You are now ready to deploy your first app!
 
#### 6. Deploy to Cloud Foundry (Hello World)
$ git clone https://github.com/vchrisb/cf-helloworld $PWD/workspace/cf-helloworld          
$ cd $PWD/workspace/cf-helloworld             
$ cf push             

#### 7. To see app status
$ cf apps       
$ curl http://cf-helloworld.<system-domain\>           
