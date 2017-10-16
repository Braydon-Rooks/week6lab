/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;


import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.jsp.JspException;

import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author 671978
 */
public class Debug extends TagSupport {

        
        
       
    @Override
    public int doStartTag() throws JspException {
        
        ServletRequest request =pageContext.getRequest();
        String url = request.getServerName();
        
        
        if(url.contains("test")||url.contains("localhost"))
        {
            String query = request.getParameter("debug");
            if(query!=null)
        {
            return EVAL_BODY_INCLUDE;
        }
        
        }
             
         return SKIP_BODY;
    }
    
}
