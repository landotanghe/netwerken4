package nieuws.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-17T14:58:49")
@StaticMetamodel(NewsItem.class)
public class NewsItem_ { 

    public static volatile SingularAttribute<NewsItem, String> author;
    public static volatile SingularAttribute<NewsItem, Date> publishDate;
    public static volatile SingularAttribute<NewsItem, Long> id;
    public static volatile SingularAttribute<NewsItem, String> message;
    public static volatile SingularAttribute<NewsItem, String> title;

}