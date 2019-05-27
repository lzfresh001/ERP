<%@page import="java.util.Random"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.Font"%>
<%@page import="java.awt.Color"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%		
		// 生成四位数的验证码
		response.setContentType("image/jpeg");//设置MIME
		//不缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control","no-cache");
		response.setDateHeader("expires", 0);
		//得到画布
		BufferedImage img=new BufferedImage(150, 40, BufferedImage.TYPE_INT_RGB);
		//得到画笔
		Graphics g=img.getGraphics();
		//设置画笔颜色
		g.setColor(Color.RED);
		g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
		g.fillRect(0, 0, 150, 40);
		g.setColor(Color.WHITE);
		g.fillRect(1, 1, 148, 38);
		//设置干扰线
		g.setColor(Color.GRAY);
		
		Random rand = new Random(); //随机数
		for(int i=0;i<100;i++){
			int a=rand.nextInt(148);
			int b=rand.nextInt(48);
			int c=rand.nextInt(13);
			int d=rand.nextInt(16);
			g.drawLine(a, b, a+c, b+d);
		}
		g.setFont(new Font("Times New Roman",Font.ITALIC,40));
		//绘制字符
		String strcode="";
		String CODE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=0;i<4;i++){
			//产生4个字符
			String code=CODE.charAt(rand.nextInt(CODE.length()))+"";
			strcode += code; //得到最终的验证码
			g.setColor(new Color(rand.nextInt(250),rand.nextInt(110),rand.nextInt(123)));
			g.translate(rand.nextInt(10), rand.nextInt(3));
			g.drawString(code, 28*i,30);
		}
		//System.out.println("*******strCode:" + strcode);
		// 将验证码存入session中
		request.getSession().setAttribute("CODE", strcode);
		// 图象生效
		g.dispose();
		//输出
		ImageIO.write(img, "jpeg", response.getOutputStream());
		
		out.clear();
		out = pageContext.pushBody();
%>













