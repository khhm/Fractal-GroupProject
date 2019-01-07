public class Julia
{
protected boolean bound;
private double x_input;
private double y_input;
private double x;
private double y;
private double znow_r;
private double znow_c;
private int niter;

//Constructor Julia
public Julia(double x,double y)
{
	x_input=x;
	y_input=y;
}

//Maps the x,y coordinates into complex number within the region of interest 
public void complexValue(double i,double j)
{
	znow_r=(((double)i*2)/800)-1;
	znow_c=1-(((double)j*2)/800);
}

//Checks the complex coordinates are in the set of Julia
public boolean boundCheck(double x,double y,int iterations)		
{
	niter=0;
	x=x_input;
	y=y_input;
	while(iterations-->0)
	{
		double znext_r=(znow_r*znow_r)-(znow_c*znow_c)+x;
		double znext_c=(2*znow_r*znow_c)+y;
		znow_r=znext_r;
		znow_c=znext_c;
		niter++;
		if((Math.pow(znow_r,2)+Math.pow(znow_c,2))>4)
		{	
			return bound=false;
		}	
	}	
	return bound=true;
}

//returns x,y coordinates
public double getX()
{
	return x;
}
public double getY()
{
	return y;
}

//returns the number of iterations took on the boundCheck
public int getIter()
{
	return niter;
}
}
