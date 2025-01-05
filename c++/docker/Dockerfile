# ベースイメージとしてUbuntuを使用
FROM ubuntu:25.04

# タイムゾーンを日本時間に設定
RUN apt-get update && \
    DEBIAN_FRONTEND=noninteractive apt-get install -y tzdata && \
    ln -fs /usr/share/zoneinfo/Asia/Tokyo /etc/localtime && \
    dpkg-reconfigure --frontend noninteractive tzdata && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

# ビルドツールをインストール
RUN apt-get update && \
    apt-get install -y software-properties-common && \
    add-apt-repository -y ppa:ubuntu-toolchain-r/test && \
    apt-get install -y gcc-15 g++-15 cmake=3.31.2-1 && \
    update-alternatives --install /usr/bin/gcc gcc /usr/bin/gcc-15 15 && \
    update-alternatives --install /usr/bin/g++ g++ /usr/bin/g++-15 15 && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

# sshdのインストール
RUN apt-get update && \
    apt-get install -y openssh-server && \
    rm -rf /var/lib/apt/lists/* && \
    echo 'root:root' chpasswd && \
    sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

# googletestのインストール
RUN apt-get update && \
    apt-get install -y git && \
    cd /tmp && \
    git clone https://github.com/google/googletest.git && \
    cd googletest && \
    mkdir build && \
    cd build && \
    cmake .. && \
    make && \
    make install && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*


WORKDIR /root
CMD ["/usr/sbin/sshd", "-D"]
