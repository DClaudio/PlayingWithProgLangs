def checkio(data):
    A=data[1][0]-data[0][0]
    B=data[1][1]-data[0][1]
    C=data[1][0]**2-data[0][0]**2+data[1][1]**2-data[0][1]**2
    D=data[2][0]-data[0][0]
    E=data[2][1]-data[0][1]
    F=data[2][0]**2-data[0][0]**2+data[2][1]**2-data[0][1]**2
    y0 = (A*F-C*D)/(2*(A*E-B*D))
    x0 = (C-2*B*y0)/(2*A)
    r=0
    
    return "(x-{x0})^2+(y-{y0})^2={r}^2".format(**{"x0" : repr(x0), "y0": repr(y0), "r":repr(r)})
