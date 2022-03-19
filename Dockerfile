FROM fedora

#update system
RUN dnf install -y https://mirrors.rpmfusion.org/free/fedora/rpmfusion-free-release-$(rpm -E %fedora).noarch.rpm https://mirrors.rpmfusion.org/nonfree/fedora/rpmfusion-nonfree-release-$(rpm -E %fedora).noarch.rpm
RUN dnf update -y

#workdir
WORKDIR /opt/justMIME

#install openjdk-11
RUN dnf install -y java-11-openjdk

COPY bin /bin
RUN chmod +x /bin/launch
RUN echo "complete -W \"bash lib build\" launch" >> /root/.bashrc

ENTRYPOINT ["launch"]
CMD ["bash"]
