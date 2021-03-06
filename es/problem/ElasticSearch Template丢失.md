##### 【问题描述】
 一线人员反馈，日志系统无法查阅最新的日志信息。
 
##### 【排查思路】
 1、首先查阅了ES的索引数据，发现索引数据正常，确认非ES异常导致。
 2、怀疑当前日志搜索过程中出现了问题，排查搜索条件，发现过滤时间戳并无异常，搜索结果一切正常，业务并没有导致此次查询出现异常。
 3、但此时发现了排序字段为ts.raw，之后查询最新索引的mapping信息，发现并无此字段，但可查询索引有该字段信息。
 4、因为mapping是根据template创建，所以，此时查询template中是否存在该字段，发现并没有。
 5、排查业务逻辑，发现在创建template时，会增加field属性，并命名为ts.raw，在查询过程中如果mapping信息中存在ts.raw则根据其排序，否则根据ts.字段排序。
 6、当前需要确认的是，为什么template丢失？
 
 之后，网上查询相关资料，并没有发现相关资料，此时一筹莫展。一线服务人员反馈，在发生此事故前，做过机器重建的操作（即，将整个机器摧毁重建），联想到如果重建后，如果选主为，新建的节点，则可能会导致其丢失，遂进行了模拟验证，发现问题跟因确实在此处。
 
#####  【总结】
 1、ES集群节点重建，可能会导致其模板信息丢失（此问题，由于我们强制性将重建节点为master节点，所以该问题必现）
