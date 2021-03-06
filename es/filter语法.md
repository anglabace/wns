## filter语法
在前边章节部分，我们一直没有提到文档的得分（结果集中_score字段）。得分表示的是一种相关度，即文档与我们搜索条件的一种匹配程度。得分越高，表明相关度越高，得分越低，表明相关度越低。
但是我们在查询时，并不是所有情况下都需要分数的，在这种场景下，我们可以使用filtering。
前边我们提到的bool查询也是支持filter语句的，这些语句被用于限定一些查询结果，但是并不会改变其分数的计算。我们来举例说明这个情况，我们使用range查询，这个允许我们通过过滤一些文档，在一个区间值内。这种方式，通常被用到数字或者日志的过滤。
这个例子使用了一个bool查询来查询账户金额在20000到30000的用户。也就是大于等于20000小于等于30000的用户。
<pre>
curl -X GET "http://localhost:9200/bank/_search?pretty" -H 'Content-Type: application/json' -d'
{
  "query": {
    "bool": {
      "must": { "match_all": {} },
      "filter": {
        "range": {
          "balance": {
            "gte": 20000,
            "lte": 30000
          }
        }
      }
    }
  }
}
'
</pre>
我们可以使用其他查询语句替换查询或者过滤部分。当前我们已经学习了match_all、match、bool、range查询语句，当然，还有很多类型的查询语句，我们就不一一学习了。因为我们当前已经理解了它是怎么工作的，将现有的知识应用在其他查询语句的学习和实验当中应该不会太难。
