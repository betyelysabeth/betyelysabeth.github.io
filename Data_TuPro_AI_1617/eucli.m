function eucli=eucli(x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,jml)
    test=x10;
    test(:,13)=0;
    data(1:9000,:)=x1;
    data(9001:18000,:)=x2;
    data(18001:27000,:)=x3;
    data(27001:36000,:)=x4;
    data(36001:45000,:)=x5;
    data(45001:54000,:)=x6;
    data(54001:63000,:)=x7;
    data(63001:72000,:)=x8;
    data(72001:81000,:)=x9;
    
    for i=1:9000
        for j=1:81000
            hasil=0;
            for k=1:10
                temp=((test(i,k)-data(j,k))^2);
                hasil=hasil+temp;
            end
            data(j,12)=sqrt(hasil);
        end
        
        [x y]=sort(data(:,12),'ascend');

        s=0;
        hasil_akhir(:,i)=x;
        for m=1:jml
           posisi=y(m,1);
           target=data(posisi,11);
           if target==1
              s=s+1;
           else
              s=s-1;
           end
        end

        if s>0
            test(i,13)=1;
        else
            test(i,13)=0;
        end
        
    end
    error=0;
    for i=1:9000
        if test(i,13) ~= test(i,11)
            error=error+1;
        end
    end
    persen_error=(error/9000)*100;
    
    eucli=persen_error;
end