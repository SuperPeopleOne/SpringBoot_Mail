package com.lenovo.service;

import com.lenovo.entity.Book;
import com.lenovo.entity.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @author Tookie
 * @date 2018-06-29
 * @version 1.0.0
 */
@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Resource
    private BookService bookService;
    @Resource
    private DemoService demoService;


    /**
     * Mail Method
     * @param to
     * @param host
     * @param port
     * @param username
     * @param password
     * @param encoding
     * @return
     */
    public int getSendHtml(String to,String host,Integer port,String username,String password,String encoding){

        try {
            String[] toArr = to.split(",");
            String strTo = "";
            for (String str : toArr) {
                if (!str.contains(".com")) {
                    strTo += str += ".com,";
                } else {
                    strTo += str + ",";
                }
            }
            String[] strToArr = strTo.split(",");
            String content = "This is content!\r\n";
            content += getContent();

            //TODO:Sender
            JavaMailSenderImpl sender = new JavaMailSenderImpl();
            sender.setHost(host);
            //TODO:Default Port Is TwentyFive
            sender.setPort(port);
            sender.setUsername(username);
            sender.setPassword(password);
            sender.setDefaultEncoding(encoding);

            //TODO:Config File Object
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            Session session = Session.getInstance(props);
            sender.setSession(session);

            MimeMessage mail = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            //TODO:Set Recipients
            helper.setTo(strToArr);
            //TODO:Set Subject
            helper.setSubject("This is subject!(" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ")");
            //TODO:Set Sender
            helper.setFrom(username);
            //String nick = javax.mail.internet.MimeUtility.encodeText("");
            //helper.setFrom(new InternetAddress(nick + "<"+username+">"));
            //TODO:Set Content
            /**
             * Adding 'true' means sending HTML web page version mail
             */
            //helper.setText("<a href='https://www.lenovo.com.cn/' style='font-size:50px;'>联想商城</a>",true);
            helper.setText(content, true);

            sender.send(mail);
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Content Method
     * @return
     */
    public String getContent(){
        String content = "";
        content += "<table border='1' cellpadding='1' cellspacing='1' ><thead>" +
                "<tr> <th>序号</th> <th>书名</th> <th>作者</th> </tr></thead><tbody>";
        List<Book> bookList = bookService.getList();
        for (Book book : bookList ) {
            content += "<tr> <td>"+book.getId()+"</td> <td>"+book.getName()+"</td> <td>"+book.getAuthor()+"</td> </tr>";
        }
        content += "</tbody></table><table border='1' cellpadding='1' cellspacing='1' ><thead><tr> <th>序号</th> <th>用户名</th> <th>密码</th> </tr></thead><tbody>";
        List<Demo> demoList = demoService.getListByDsFirst();
        for (Demo demo : demoList ) {
            content += "<tr> <td>"+demo.getId()+"</td> <td>"+demo.getUser()+"</td> <td>"+demo.getPwd()+"</td> </tr>";
        }
        content += "</tbody></table>";
        return content;
    }



}
