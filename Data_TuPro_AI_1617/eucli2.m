function eucli2=eucli2(latih,jml,test)
    test(:,11)=0;
    
    for i=1:10000
        for j=1:90000
            hasil=0;
            for k=1:10
                temp=((test(i,k)-latih(j,k))^2);
                hasil=hasil+temp;
            end
            latih(j,12)=sqrt(hasil);
        end
        
        [x y]=sort(latih(:,12),'ascend');

        s=0;
        for l=1:jml
           posisi=y(l,1);
           target=latih(posisi,11);
           if target==1
              s=s+1;
           else
              s=s-1;
           end
        end

        if s>0
            test(i,11)=1;
        else
            test(i,11)=0;
        end
    end
    
    eucli2=test;
end