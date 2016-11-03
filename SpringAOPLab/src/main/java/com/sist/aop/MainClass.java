package com.sist.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * # ºñÁö´Ï½º ÄÄÆ÷³ÍÆ® °³¹ß
 * 	1. °¡Àå Áß¿äÇÑ ¿øÄ¢
 * 		1) ³·Àº °áÇÕµµ ==> ÀÇÁ¸¼º ÁÖÀÔ (DI) ÀÌ¿ë
 * 		2) ³ôÀº ÀÀÁýµµ ==> AOP ÀÌ¿ë
 * 
 * #AOP (Aspect Oriented Programming)
 * 	1. ÇÙ½É ±â´É°ú ºÎ°¡ ±â´É
 * 		1) ÇÙ½É±â´É(Core Conerns) 
 * 			: ¾÷¹«(Biz) ·ÎÁ÷À» Æ÷ÇÔÇÏ´Â ±â´É
 * 		2) ºÎ°¡±â´É(Cross-cutting Concerns) 
 * 			: ÇÙ½É±â´ÉÀ» µµ¿ÍÁÖ´Â ºÎ°¡ÀûÀÎ ±â´É(·Î±ë, º¸¾È µî)
 * 		
 * 		==> ±âÁ¸ÀÇ Application¿¡¼­´Â oopÀÇ ±âº»¿øÄ¢À» Àû¿ëÇÏ¿©µµ
 * 			ÇÙ½É±â´É¿¡¼­ ºÎ°¡ ±â´ÉÀ» ºÐ¸®, ¸ðµâÈ­ ÇÏ´Â °ÍÀÌ ¾î·Á¿ò
 *		==> ÀÌ¸¦ º¸¿ÏÇÏ±â À§ÇØ Åº»ýÇÑ °ÍÀÌ AOP
 *
 *	2. AOP °³¿ä
 *		1) °³³ä
 *			- ¾îÇÃ¸®ÄÉÀÌ¼ÇÀÇ °ü½É»çÀÇ ºÐ¸® (±â´ÉÀÇ ºÐ¸®)
 *			    Áï, ÇÙ½ÉÀûÀÎ ±â´É¿¡¼­ ºÎ°¡ÀûÀÎ ±â´ÉÀ» ºÐ¸®ÇÔ.
 *			- ºÐ¸®ÇÑ ºÎ°¡±â´ÉÀ» ¾Ö½ºÆÑÆ®(Aspect)¶ó´Â µ¶Æ¯ÇÑ  ¸ðµâ ÇüÅÂ·Î ¸¸µé¾î¼­
 *			    ¼³°èÇÏ°í °³¹ßÇÏ´Â ¹æ¹ý
 *
 *		2) ¿ªÇÒ
 *			- AOP´Â ºÎ°¡±â´ÉÀ» ¾Ö½ºÆÑÆ®·Î Á¤ÀÇÇÏ¿©, ÇÙ½É±â´É¿¡¼­ ºÎ°¡±â´ÉÀ» ºÐ¸®ÇÔ
 *			    ÇÙ½É±â´ÉÀ» ¼³°è, ±¸ÇöÇÒ ¶§, °´Ã¼ÁöÇâÀûÀÎ °¡Ä¡¸¦ ÁöÅ³ ¼ö ÀÖ°Ô µµ¿ÍÁÜ
 *		
 *	3. AOP ¿ë¾î
 *		1) ¾Ö½ºÆÑÆ®(Aspect)
 *			- Aspect = Advice(¾îµå¹ÙÀÌ½º : ºÎ°¡±â´ÉÀ» Á¤ÀÇÇÑ ÄÚµå) 
 *						+ PointCut(Æ÷ÀÎÆ® ÄÆ : ¾îµå¹ÙÀÌ½º¸¦ ¾îµð¿¡ Àû¿ëÇÒÁö °áÁ¤ÇÏ´Â °Í) 	
 *		  	- ÇÙ½É±â´É ÄÚµå »çÀÌ¿¡ Ä§ÅõµÈ ºÎ°¡±â´ÉÀ» µ¶¸³ÀûÀÎ ¾Ö½ºÆÑÆ®·Î ±¸ºÐÇØ ³¾ ¼ö ÀÖÀ½
 *			- ±¸ºÐµÈ ºÎ°¡±â´É ¾Ö½ºÆÑÆ®¸¦ ·±Å¸ÀÓ½Ã¿¡ ÇÊ¿äÇÑ À§Ä¡¿¡ µ¿ÀûÀ¸·Î Âü¿©ÇÒ ¼ö ÀÖÀ½
 *			- AOPÀÇ ±âº» ¸ðµâ
 *			- Aspect´Â ½Ì±ÛÅæ ÇüÅÂÀÇ °´Ã¼·Î Á¸ÀçÇÔ
 *		
 *		2) Å¸°Ù(Target)
 *			- ÇÙ½É ±â´ÉÀ» ´ã°í ÀÖ´Â ¸ðµâ
 *			- ºñÁö´Ï½º ·ÎÁ÷À» ±¸ÇöÇÑ ºÎºÐ, Å¬·¡½º ³»ÀÇ Æ¯Á¤ ¸Þ¼­µå
 *			- Å¸°ÙÀº ºÎ°¡±â´ÉÀ» ºÎ¿©ÇÒ ´ë»óÀÌ µÊ
 *		
 *		3) ¾îµå¹ÙÀÌ½º(advice)
 *			- ¾îµå¹ÙÀÌ½º´Â Å¸°Ù¿¡ Á¦°øÇÒ ºÎ°¡±â´ÉÀ» ´ã°í ÀÖ´Â ¸ðµâ
 *		
 *		4) Á¶ÀÎ Æ÷ÀÎÆ®(Join Point)
 *			- ¾îµå¹ÙÀÌ½º°¡ Àû¿ëµÉ ¼ö ÀÖ´Â À§Ä¡¸¦ ¸»ÇÔ
 *			- Áï, Å¸°Ù°´Ã¼°¡ ±¸ÇöÇÑ ÀÎÅÍÆäÀÌ½ºÀÇ ¸ðµç ¸Þ¼­µå´Â Á¶ÀÎ Æ÷ÀÎµå°¡ µÊ
 *
 *		5) Æ÷ÀÎÆ® ÄÆ(PointCut)
 *			- ¾îµå¹ÙÀÌ½º¸¦ Àû¿ëÇÒ Å¸°ÙÀÇ ¸Þ¼­µå¸¦  ¼±º°ÇÏ´Â Á¤±Ô Ç¥Çö½Ä		 
 *			- Áï, Æ÷ÀÎÆ® ÄÆ Ç¥Çö½ÄÀº executionÀ¸·Î ½ÃÀÛÇÏ°í, 
 *			    ¸Å¼­µåÀÇ Signature¸¦ ºñ±³ÇÏ´Â ¹æ¹ýÀ» ÁÖ·Î ÀÌ¿ëÇÔ
 *
 *		6) ¾îµå¹ÙÀÌÀú(Advisor)
 *			- ¾îµå¹ÙÀÌÁ® = Aspect = ¾îµå¹ÙÀÌ½º + Æ÷ÀÎÆ®ÄÆ
 *			- ½ºÇÁ¸µ AOP¿¡¼­¸¸ »ç¿ëÇÏ´Â ¿ë¾î
 *
 *		7) À§ºù(Weaving)
 *			- Æ÷ÀÎÆ® ÄÆ¿¡ ÀÇÇØ¼­ °áÁ¤µÈ Å¸±êÀÇ Á¶ÀÎ Æ÷ÀÎÆ®¿¡
 *			    ºÎ°¡±â´É(¾îµå¹ÙÀÌ½º)¸¦ »ðÀÔÇÏ´Â °úÁ¤À» ¶æÇÔ.
 *			- À§ºùÀº AOP°¡ ÇÙ½É±â´É(Å¸°Ù)ÀÇ ÄÚµå¿¡ ¿µÇâÀ» ÁÖÁö ¾ÊÀ¸¸é¼­
 *			    ÇÊ¿äÇÑ ºÎ°¡±â´É(¾îµå¹ÙÀÌ½º)À» Ãß°¡ÇÒ ¼ö ÀÖµµ·Ï ÇØÁÖ´Â 
 *			    ÇÙ½ÉÀûÀÎ Ã³¸® °úÁ¤
 *	
 * 	4. Spring AOPÀÇ Æ¯Â¡
 * 		1) SpringÀº ÇÁ·Ï½Ã(Proxy) ±â¹Ý AOP Áö¿ø
 * 			- SpringÀº Å¸±ê(Target)°´Ã¼¿¡ ´ëÇÑ ÇÁ·Ï½Ã¸¦ ¸¸µé¾î Á¦°øÇÔ
 * 			- Å¸°ÙÀ» °¨½Î´Â ÇÁ·Ï½Ã´Â ½ÇÇà½Ã°£(Runtime)¿¡ »ý¼ºµÊ
 * 			- ÇÁ·Ï½Ã´Â ¾îµå¹ÙÀÌ½º¸¦ Å¸±ê °´Ã¼¿¡ Àû¿ëÇÏ¸é¼­ »ý¼ºµÇ´Â °´Ã¼ÀÓ 			
 * 		
 * 		2) ÇÁ·Ï½Ã(Proxy)°¡ È£ÃâÀ» °¡·ÎÃ¨(intercept)
 * 			- ÀüÃ³¸® ¾îµå¹ÙÀÌ½º 
 * 				: ÇÁ·Ï½Ã´Â Å¸±ê °´Ã¼¿¡ ´ëÇÑ È£­ŒÀ» °¡·ÎÃ¦ ´ÙÀ½ 
 * 				    ¾îµå¹ÙÀÌ½ºÀÇ ºÎ°¡±â´É ·ÎÁ÷À» ¼öÇàÇÏ°í ³­ ÈÄ
 * 			             Å¸±êÀÇ ÇÙ½É±â´É ·ÎÁ÷À» È£ÃâÇÔ
 * 		
 * 			- ÈÄÃ³¸® ¾îµå¹ÙÀÌ½º
 * 				: Å¸±êÀÇ ÇÙ½É±â´É ·ÎÁ÷ ¸Þ¼­µå¸¦ È£ÃâÇÑ ÈÄ¿¡ 
 * 				    ºÎ°¡±â´É(¾îµå¹ÙÀÌ½º)¸¦ ¼öÇàÇÏ´Â °æ¿ì  
 * 
 * 		3) Spring AOP´Â ¸Þ¼­µå Á¶ÀÎ Æ÷ÀÎÆ®¸¸ Áö¿ø ÇÔ.
 * 			- SpringÀº µ¿Àû ÇÁ·Ï½Ã¸¦ ±â¹ÝÀ¸·Î AOP¸¦ ±¸ÇöÇÏ¹Ç·Î
 * 			    ¸Þ¼­µå Á¶ÀÎ Æ÷ÀÎÆ®¸¸ Áö¿øÇÔ
 * 			- Áï, ÇÙ½É±â´É(Å¸±ê)ÀÇ ¸Þ¼­µå°¡ È£ÃâµÇ´Â ·±Å¸ÀÓ ½ÃÁ¡¿¡¸¸
 * 			    ºÎ°¡±â´É(¾îµå¹ÙÀÌ½º)¸¦ Àû¿ëÇÒ ¼ö ÀÖÀ½
 * 			- °´Ã¼ÀÇ »ý¼º, ÇÊµå°ªÀÇ Á¶È¸¿Í Á¶ÀÛ, static ¸Þ¼­µå È£Ãâ ¹× ÃÊ±âÈ­ µîÀÇ
 * 			    ´Ù¾çÇÑ ÀÛ¾÷¿¡ ºÎ°¡±â´ÉÀ» Àû¿ë(AspectJ °í±Þ AOP ÇÁ·¹ÀÓ¿öÅ©ÀÇ °æ¿ì)
 *	
 *	5. Spring AOPÀÇ ±¸Çö ¹æ½Ä
 *		1) XML ±â¹ÝÀÇ POJO Å¬·¡½º¸¦ ÀÌ¿ëÇÑ AOP ±¸Çö
 *			- ºÎ°¡±â´ÉÀ» Á¦°øÇÏ´Â Advice Å¬·¡½º¸¦ ÀÛ¼ºÇÔ
 *			- XML ¼³Á¤ ÆÄÀÏ¿¡ <aop:config>¸¦ ÀÌ¿ëÇØ¼­ ¾Ö½ºÆÑÆ®(¾îµå¹ÙÀÌ½º+Æ÷ÀÎÆ®ÄÆ)À» ¼³Á¤ÇÔ.
 *				
 *		2) Aspect ¾î³ëÅ×ÀÌ¼ÇÀ» ÀÌ¿ëÇÑ AOP ±¸Çö	
 *			- @Aspect ¾î³ëÅ×ÀÌ¼ÇÀ» ÀÌ¿ëÇÏ¿©
 *			     ºÎ°¡±â´ÉÀ» Á¦°øÇÏ´Â Aspect Å¬·¡½º¸¦ ÀÛ¼º
 *			  AspectÅ¬·¡½º´Â ¾îµå¹ÙÀÌ½º¸¦ ±¸ÇöÇÏ´Â ¸Þ¼­µå¿Í Æ÷ÀÎÆ® ÄÆÀ» Æ÷ÇÔÇÔ.
 *			- XML ¼³Á¤ ÆÄÀÏ¿¡ <aop:aspectj-autoproxy/>¸¦ ¼³Á¤ÇÔ.
 *
 *	6. AdviceÀÇ Á¾·ù
 *		1) Around ¾îµå¹ÙÀÌ½º
 *			- JoinPoint ¾Õ°ú µÚ¿¡¼­ ½ÇÇàµÇ´Â Advice
 *			- Å¸±ê ¸Þ¼­µå°¡ È£ÃâµÇ±â ÀÌÀü(Before)½ÃÁ¡°ú ÀÌÈÄ(after) ½ÃÁ¡¿¡
 *			    ¸ðµÎ Ã³¸®ÇØ¾ßÇÒ ÇÊ¿ä°¡ ÀÖ´Â ºÎ°¡±â´ÉÀ» Á¤ÀÇÇÔ
 *
 *		2) Before ¾îµå¹ÙÀÌ½º
 *			- JoinPoint ¾Õ¿¡¼­ ½ÇÇàµÇ´Â Advice
 *			- Å¸±êÀÇ ¸Þ¼­µå°¡ ½ÇÇàµÇ±â ÀÌÀü(Before) ½ÃÁ¡¿¡¼­ Ã³¸®ÇØ¾ßÇÒ ÇÊ¿ä°¡ ÀÖ´Â ºÎ°¡ ±â´ÉÀ» Á¤ÀÇÇÔ
 *		
 *		3) After Returning ¾îµå¹ÙÀÌ½º
 *			- JoinPoint ¸Þ¼­µå È£ÅøÀÌ Á¤»óÀûÀ¸·Î Á¾·áµÈ µÚ¿¡ ½ÇÇàµÇ´Â Advice
 *			    Å¸±êÀÇ ¸Þ¼­µå°¡ Á¤»óÀûÀ¸·Î ½ÇÇàµÈ ÀÌÈÄ(After) ½ÃÁ¡¿¡ Ã³¸®ÇØ¾ßÇÒ ÇÊ¿ä°¡ ÀÖ´Â ºÎ°¡ ±â´ÉÀ» Á¤ÀÇ ÇÔ
 *
 *		4) After Throwing ¾îµå¹ÙÀÌ½º
 *			- ¿¹¿Ü°¡ ¹ß»ýÇÒ ¶§ ½ÇÇàµÇ´Â Advice
 *			- Å¸±ê ¸Þ¼­µå°¡ ¿¹¿Ü¸¦ ¹ßÇà½ÃÅ² ÀÌÈÄ(After) ½ÃÁ¡¿¡ Ã³¸®ÇØ¾ßÇÒ ÇÊ¿ä°¡ ÀÖ´Â ºÎ°¡±â´ÉÀ» Á¤ÀÇÇÔ.
 */	
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		
		MyEmp emp=app.getBean("me", MyEmp.class);
		emp.dbConnection();
	}
}
