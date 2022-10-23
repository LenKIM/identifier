# Identifier

[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/LenKIM/identifier/blob/main/LICENSE)

[![identifier](https://jitpack.io/v/LenKIM/identifier.svg)](https://jitpack.io/#LenKIM/identifier)


This tool helps you give meaning to ID in ours Domain


## Motivation

Wouldn't it be nice if the identifier (ex.1,2,3,4,5,6,7,8) had meaning?

I thought that the identifiers of commonly used entities could also be given meaning.

Default LongValueGenerator inspired by the snowflake project which Twitter Developed

## Goal

- Identifier can make each aggregate ID on Micro Services can be meaningful.
- more easily distinguish ID we commonly used by Identifier

## UseCase

- No more need Database Auto Increment!
- to give an ID to entity of domain on microservices.

## Setup

```java
implementation 'com.github.LenKIM.identifier:identifier-generator:0.0.35'
```

if you want to use in spring-boot-starter

```java
implementation 'com.github.LenKIM.identifier:identifier-spring-boot-starter:0.0.35'
```

## How to use

````java
long expectedAggregateId=10L;
LongValueGenerator sut = new SnowFlakeLongValueGenerator(expectedAggregateId);

long generatedId = sut.gen();
````

when using springboot

```yml
// application.yml
id-generator:
  aggregateId: 1L
```

```java

@Component
class FooComponent {

    private final LongValueGenerator generator;

    Foo(LongValueGenerator generator) {
        this.generator = generator;
    }

    public Long getId() {
        Long generatedId = generator.gen();
        return generatedId;
    }
}

```
