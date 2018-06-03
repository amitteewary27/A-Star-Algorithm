import java.util.*;
class que
{
int f,r,n,pr[],cost[];
String q[];
que(int n1)
{
	f=-1;
	r=-1;
	n=n1*n1;
	q=new String[n];
	pr=new int[n];
	cost=new int[n];
}
public void insert(String inp,int pr1,int cst)
{
//System.out.println("\nInserting "+inp);
	if(r==n-1)
	{
	}else if(f==-1&&r==-1)
	{
		f=0;
		r=0;
		q[r]=inp;
		pr[r]=pr1;
		cost[r]=cst;
	}else
	{
		r++;
		q[r]=inp;
		pr[r]=pr1;
		cost[r]=cst;
		int min=0;
		int temp;
		int flag=0;
		String tempc;
		//Prioritising by wieght;
		for(int i=f;i<=r;i++)
		{
			
		 min=i;
		 for(int j=i+1;j<=r;j++)
			{
			 if(pr[min]>pr[j])
			  {
			
			   min=j;
			   flag=1;
			   }
			}
			if(flag==1)
			{
			 temp=pr[i];
			 pr[i]=pr[min];
			 pr[min]=temp;
			 temp=cost[i];
			 cost[i]=cost[min];
			 cost[min]=temp;
			 tempc=q[i];
			 q[i]=q[min];
		 	 q[min]=tempc;
			}
			flag=0;
		}
	}
}
public void del()
{

	String temp;
	if(f==-1)
	{
	}else if(f==r)
	{
		temp=q[f];
		q[f]="-";
		f=-1;
		r=-1;
	}else
	{
		temp=q[f];
		q[f]="-";
		f++;
	}
}
public String getf()
{
	if(f!=-1)
	return q[f];
	return "-";
}
public int getCost()
{
 if(f!=-1)
 return cost[f];
 return 0;
}
}
class Ast
{
	public static void main(String ar[])
	{
		int mat[][],h[];
		int n,a,b,c;
		int st,e;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no. of nodes:");
		n=sc.nextInt();
		mat=new int[n][n];
		h=new int[n];
		System.out.println("Enter the graph(1 if path is there):");
		String s;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(i!=j)
				{
				System.out.print((char)(i+97)+"->"+(char)(j+97)+":");
				
				mat[i][j]=sc.nextInt();
				}else
				mat[i][j]=-1;
			}
		}
		char ch;
		st=1-1;
		e=n-1;
//A* Algorithm Logic;		
		a=st;
		b=0;
		que q=new que(n);
		String path=new String();
		String visit[]=new String[n*n-n];
		int vcost[]=new int[n*n];
		int countv=0;
		int cost=0;
		String adnode=new String();
		char chp=(char)(a+97);
		path=chp+"";
		cost=h[a]+0;
		q.insert(path,cost,0);
		String temppt,temppt1;
		int lenpt;
		int pcost,pcost1;
		int countw=0;
		do
		{
		if(q.getf().equals("-"))
		break;
		//else
		temppt=q.getf();
		//System.out.println("Transaction for :"+temppt);
		lenpt=temppt.length();
		a=(int)temppt.charAt(lenpt-1)-97;
	//	System.out.println("a="+a+"char:"+temppt.charAt(lenpt-1));
		pcost=q.getCost();
		visit[countv++]=temppt;
		vcost[countv-1]=pcost;
		q.del();
		
		for(b=0;b<n;b++)
		{
		temppt1=temppt;
		pcost1=pcost;
		if(mat[a][b]!=0)
		{
		 path="->"+(char)(b+97);
		 pcost1=pcost+mat[a][b];
		 cost=pcost1+h[a];
		 temppt1+=path;
		// System.out.println("Insert in loop "+temppt1);
		 q.insert(temppt1,cost,pcost1);
		
		}
		}
		}while(true);
		//System.out.println("\n\nOutput:");
		int arr[]={2,2};
		int pval[]=new int[visit.length];
		int pval1=0,a1,a2;
		String str;
		char[] chrct;
		for(int i=0;i<countv;i++)
		{
		//System.out.println("path:"+visit[i]+" cost:"+vcost[i]);
		str=visit[i];
		chrct=str.toCharArray();
		for(int j=0;j<chrct.length;j++)
		{
			a1=(int)chrct[j];
			if(a1>=97&&(a1<=(int)'z'))
			{
				pval1=pval1*10+arr[a1-97];
			}
		}
		pval[i]=pval1;
		pval1=0;
		//System.out.println("pval="+pval[i]);
		}
		int v1,v2,v3,v4=0,v5[],l1,countl=0;
		int factr[],fcount=0;
		float n1;
		int flag=0;
		int min=0;
		//v5=new int[10];
		factr=new int[100];
		int fl=0;
		  int mpos=0;
		for(int i=0;i<countv;i++)
		{
		  v1=pval[i];
		  v2=v1;
		  n1=v1;
		  //System.out.println("v1="+v1);
		  for(int ii=1;ii<=(int)n1;ii++)
		{
			if(n1/ii==((int)n1/ii))
			{
				factr[fcount]=ii;
				fcount++;
			}
		}
		  while(v2>0)
		  {
			  v2=v2/10;
			  countl++;
		  }
		  l1=countl;
		  v2=v1;
		  countl=0;
		  v5=new int[l1];
		  v4=0;
		
		  while(countl<l1)
		  {
			  v3=v2%10;
			  v5[countl]=v3;
			  
			  v4=v4+v3;
			  
			  v2=v2/10;
			  countl++;
		  }
		  countl=0;
		  
		  for(int j=0;j<l1;j++)
		  {
			  
			  for(int k=j+1;k<l1;k++)
			  {
				  //System.out.println(v5[k]+"==v5=="+v5[j]);
				  if(v5[k]==v5[j])
				  {
					  fl=1;
					//  System.out.println("fl changed");
					  //sc.nextInt();
					  break;
				  }
			  }
			//  System.out.println("fl="+fl);
			  if(fl==1)
			  {
				  fl=0;
				  continue;
			  }
			  for(int k=0;k<fcount;k++)
			  {
				  //System.out.println(v5[j]+"=fact="+factr[k]);
				  if(factr[k]==v5[j])
				  {
					//System.out.println("Flag changed");
					flag=1;
					break;
				  }else
					  flag=0;
			  }
		  }
		  //System.out.println("flag="+flag);
		  if(flag==1)
			  if(v4>min)
			  {
				  mpos=v1;
				  //System.out.println("mpos="+mpos);
				  min=v4;
			  } //System.out.println("\nmin="+min);
		  //System.out.println("v4="+v4);
		  v4=0;
		}
		System.out.println("v5="+mpos+"tot="+min);
  }

}




