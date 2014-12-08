jackson-module-scala-172
========================

Trying to demonstrate [Issue 172](https://github.com/FasterXML/jackson-module-scala/issues/172) from the Jackson Scala Module Project.

Steps to reproduce:

1. Clone this repository.
2. Run `gradle run`.

The output on my machine is:

```
$ gradle run
:compileJava UP-TO-DATE
:compileScala
:processResources UP-TO-DATE
:classes
:run
Exception in thread "main" com.fasterxml.jackson.databind.JsonMappingException: Issue172$A cannot be cast to java.lang.Number (through reference chain: B["values"]->scala.collection.convert.IterableWrapper[0])
	at com.fasterxml.jackson.databind.JsonMappingException.wrapWithPath(JsonMappingException.java:210)
	at com.fasterxml.jackson.databind.JsonMappingException.wrapWithPath(JsonMappingException.java:189)
	at com.fasterxml.jackson.databind.ser.std.StdSerializer.wrapAndThrow(StdSerializer.java:213)
	at com.fasterxml.jackson.databind.ser.std.CollectionSerializer.serializeContentsUsing(CollectionSerializer.java:153)
	at com.fasterxml.jackson.databind.ser.std.CollectionSerializer.serializeContents(CollectionSerializer.java:87)
	at com.fasterxml.jackson.module.scala.ser.IterableSerializer.serializeContents(IterableSerializerModule.scala:30)
	at com.fasterxml.jackson.module.scala.ser.IterableSerializer.serializeContents(IterableSerializerModule.scala:16)
	at com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase.serialize(AsArraySerializerBase.java:183)
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:505)
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:639)
	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:152)
	at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:128)
	at com.fasterxml.jackson.databind.ObjectMapper._configAndWriteValue(ObjectMapper.java:2881)
	at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:2338)
	at Issue172$.delayedEndpoint$Issue172$1(Issue172.scala:10)
	at Issue172$delayedInit$body.apply(Issue172.scala:4)
	at scala.Function0$class.apply$mcV$sp(Function0.scala:40)
	at scala.runtime.AbstractFunction0.apply$mcV$sp(AbstractFunction0.scala:12)
	at scala.App$$anonfun$main$1.apply(App.scala:76)
	at scala.App$$anonfun$main$1.apply(App.scala:76)
	at scala.collection.immutable.List.foreach(List.scala:381)
	at scala.collection.generic.TraversableForwarder$class.foreach(TraversableForwarder.scala:35)
	at scala.App$class.main(App.scala:76)
	at Issue172$.main(Issue172.scala:4)
	at Issue172.main(Issue172.scala)
Caused by: java.lang.ClassCastException: Issue172$A cannot be cast to java.lang.Number
	at com.fasterxml.jackson.databind.ser.std.NumberSerializer.serialize(NumberSerializer.java:21)
	at com.fasterxml.jackson.databind.ser.std.CollectionSerializer.serializeContentsUsing(CollectionSerializer.java:145)
	... 21 more
```
