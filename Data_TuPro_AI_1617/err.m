function err=err(x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,k)
    salah1(1,1)=eucli(x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,k);
    salah1(2,1)=eucli(x10,x2,x3,x4,x5,x6,x7,x8,x9,x1,k);
    salah1(3,1)=eucli(x1,x10,x3,x4,x5,x6,x7,x8,x9,x2,k);
    salah1(4,1)=eucli(x1,x2,x10,x4,x5,x6,x7,x8,x9,x3,k);
    salah1(5,1)=eucli(x1,x2,x3,x10,x5,x6,x7,x8,x9,x4,k);
    salah1(6,1)=eucli(x1,x2,x3,x4,x10,x6,x7,x8,x9,x5,k);
    salah1(7,1)=eucli(x1,x2,x3,x4,x5,x10,x7,x8,x9,x6,k);
    salah1(8,1)=eucli(x1,x2,x3,x4,x5,x6,x10,x8,x9,x7,k);
    salah1(9,1)=eucli(x1,x2,x3,x4,x5,x6,x7,x10,x9,x8,k);
    salah1(10,1)=eucli(x1,x2,x3,x4,x5,x6,x7,x8,x10,x9,k);
    salahtot=salah1(1,1)+salah1(2,1)+salah1(3,1)+salah1(4,1)+salah1(5,1)+salah1(6,1)+salah1(7,1)+salah1(8,1)+salah1(9,1)+salah1(10,1);
    jml=salahtot/10;
    err=jml;
end