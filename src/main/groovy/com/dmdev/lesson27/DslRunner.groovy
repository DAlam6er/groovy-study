package com.dmdev.lesson27

import static com.dmdev.lesson27.DslBuilder.*

//def email = new Email()
//email.setFrom("from@mail.ru")
//email.setTo("to@gmail.ru")
//email.setTitle("title")
//
//def body = new EmailBody()
//body.setText("message content")
//body.setImages(List.of("image.jpg"))
//email.setBody(body)

// метод mail возвращает MailSpecification
// метод body возвращает BodySpecification
mail {
    from "from@mail.ru"
    to "to@mail.ru"
    title "title"
    body {
        text "message content"
        images(['image.jpg', 'image2.png'])
        image 'test.jpeg'
    }
}
