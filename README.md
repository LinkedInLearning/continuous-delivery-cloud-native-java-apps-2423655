# Continuous Delivery for Cloud Native Java Apps
This is the repository for the LinkedIn Learning course `Continuous Delivery for Cloud Native Java Apps`. The full course is available from [LinkedIn Learning][lil-course-url].

_See the readme file in the main branch for updated instructions and information._
## Instructions
This repository has branches for each of the videos in the course. You can use the branch pop up menu in github to switch to a specific branch and take a look at the course at that stage, or you can add `/tree/BRANCH_NAME` to the URL to go to the branch you want to access.

## Branches
The branches are structured to correspond to the videos in the course. The naming convention is `CHAPTER#_MOVIE#`. As an example, the branch named `02_03` corresponds to the second chapter and the third video in that chapter. 
Some branches will have a beginning and an end state. These are marked with the letters `b` for "beginning" and `e` for "end". The `b` branch contains the code as it is at the beginning of the movie. The `e` branch contains the code as it is at the end of the movie. The `main` branch holds the final state of the code when in the course.

When switching from one exercise files branch to the next after making changes to the files, you may get a message like this:

    error: Your local changes to the following files would be overwritten by checkout:        [files]
    Please commit your changes or stash them before you switch branches.
    Aborting

To resolve this issue:
	
    Add changes to git using this command: git add .
	Commit changes using this command: git commit -m "some message"

## Lab Environment
This course is accompanied by a lab environment that includes the required tools and platforms for completing the exercise files in the course.  The lab environment is setup using Vagrant and runs within an Ubuntu virtual machine on your workstation using VirtualBox.  The Vagrantfile is found within the `lab-setup` directory within the exercise files for the course.  At a minimum, the lab envrionment will require 8GB of RAM and 3 CPUs to run the virtual machine.

Within the lab environment, you will find a copy of the exercise files in their initial state located on the desktop.  The exercise files are not managed with Git, so you must copy the files for a particular lesson into the virtual machine from the exercise files stored on your local workstation outside of the virtual machine.  This is necessary because throughout the course you will create Git repositories for the individual microservices found inside the exercise files directory.

## Installing
1. To launch the lab environment, you must have the following installed:
	- [VirtualBox Version 6.1.26][vbox-url]
	- [Vagrant Version 2.2.18][vagrant-url]
2. Clone this repository into your local machine using the terminal (Mac), CMD (Windows), or a GUI tool like SourceTree.
3. Navigate into the `lab-setup` directory within the exercise files via the command line.
4. Install the VBguest Plugin Version 0.30.0 using the command: `vagrant plugin install vagrant-vbguest`
5. Launch the lab using the command: `vagrant up`


[0]: # (Replace these placeholder URLs with actual course URLs)

[lil-course-url]: https://www.linkedin.com/learning/
[virtualbox-url]: https://www.virtualbox.org/wiki/Download_Old_Builds_6_1
[vagrant-url]: https://www.vagrantup.com/downloads
[lil-thumbnail-url]: http://

