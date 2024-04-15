create sequence if not exists course_seq
    increment by 50;

alter sequence course_seq owner to myuser;

create sequence if not exists student_seq
    increment by 50;

alter sequence student_seq owner to myuser;

create table if not exists course (
    id bigint primary key not null,
    name character varying(255)
);
create table if not exists student (
    id bigint primary key not null,
    first_name character varying(255),
    last_name character varying(255)
);

create table if not exists course_students (
    courses_id bigint not null,
    students_id bigint not null,
    primary key (courses_id, students_id),
    foreign key (students_id) references student (id)
        match simple on update no action on delete no action,
    foreign key (courses_id) references course (id)
        match simple on update no action on delete no action
);




