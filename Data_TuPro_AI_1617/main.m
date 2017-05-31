clc,clear;
load Train.mat;
k1=data(1:9000,:);
k2=data(9001:18000,:);
k3=data(18001:27000,:);
k4=data(27001:36000,:);
k5=data(36001:45000,:);
k6=data(45001:54000,:);
k7=data(54001:63000,:);
k8=data(63001:72000,:);
k9=data(72001:81000,:);
k10=data(81001:90000,:);
k=1;

for i=1:3
    salah(i,51)=err(k1,k2,k3,k4,k5,k6,k7,k8,k9,k10,k); 
    k=k+2;
end

latih=data;
[x y]=sort(salah(:,1),'ascend');
k=y(1,1);

load Test.mat;
test=data;
hasil_akhir=eucli2(latih,k,test); 

filename = 'D:\Data_TuPro_AI_1617\1tigakill.xlsx';
xlswrite(filename,hasil_akhir);