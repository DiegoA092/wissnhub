create table topics(

    id bigint not null auto_increment,
    title varchar(100) not null,
    message varchar(500),
    creation_date datetime not null,
    status varchar(100),
    user_id bigint not null,
    course_id bigint not null,
    active tinyint not null,

    primary key(id),
    constraint fk_topics_user_id foreign key(user_id) references users(id)

);