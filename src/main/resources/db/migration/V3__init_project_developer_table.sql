CREATE TABLE "project_developer"
(
    project_id INT not null,
    developer_id INT not null,
    primary key (project_id, developer_id),
    FOREIGN KEY (project_id) references project (id),
    foreign key (developer_id) references developer (id)
);