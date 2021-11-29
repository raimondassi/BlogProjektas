INSERT INTO users(id, username, email, password)
VALUES ('c2aa5f20-2441-40f8-8cce-d31dbd17bc84', 'user', 'user@user.com',
        '{bcrypt}$2a$10$jYIbAef1H7S.womsk7MRtOCSEx/DgM7CZ1nNeLLzoZ/OPs0a25DV2'), /*pass->user*/
       ('bd8968db-ad2a-4dd0-a0ab-7eebcc05427e', 'admin', 'admin@admin.com',
        '{bcrypt}$2a$10$VylYhXDaKC7W28tQTvYYkOdZIj2pnPVIobXOConbXy3xeBcF6Xuni'); /*pass->admin*/

INSERT INTO roles (id, name)
VALUES ('60dbb7bb-99a0-42eb-a837-8be6b697c074', 'USER'),
       ('3906c549-44bf-494b-9537-5e1658a029a8', 'ADMIN');


INSERT INTO blogCategories(id, name)
VALUES ('48a95af7-8b83-4a08-8001-0f865db8ea00', 'JAVA'),
       ('48a95af7-8b83-4a08-8001-0f865db8ea01', 'JS'),
       ('48a95af7-8b83-4a08-8001-0f865db8ea02', 'HTML'),
       ('48a95af7-8b83-4a08-8001-0f865db8ea03', 'CSS'),
       ('48a95af7-8b83-4a08-8001-0f865db8ea04', 'REACT'),
       ('48a95af7-8b83-4a08-8001-0f865db8ea05', 'INTELLIJ');

INSERT INTO blogs(id, title, image, text, date, blogcategory_id)
VALUES ('48a95af7-8b83-4a08-8001-0f865db8ea10', 'title1', 'image1', 'text3', '2015-12-26',
        '48a95af7-8b83-4a08-8001-0f865db8ea00'),
       ('48a95af7-8b83-4a08-8001-0f865db8ea11', 'title2', 'image2', 'text3', '2015-12-27',
        '48a95af7-8b83-4a08-8001-0f865db8ea01'),
       ('48a95af7-8b83-4a08-8001-0f865db8ea12', 'title2', 'image2', 'text3', '2015-12-28',
        '48a95af7-8b83-4a08-8001-0f865db8ea02'),
       ('48a95af7-8b83-4a08-8001-0f865db8ea13', 'title2', 'image2', 'text3', '2015-12-29',
        '48a95af7-8b83-4a08-8001-0f865db8ea03');

INSERT INTO comments(id, user_id, blog_id, text, date)
VALUES ('48a95af7-8b83-4a08-8001-0f865db8ea20', 'c2aa5f20-2441-40f8-8cce-d31dbd17bc84',
        '48a95af7-8b83-4a08-8001-0f865db8ea10', 'eziukas miske', '2020-10-15'),
       ('48a95af7-8b83-4a08-8001-0f865db8ea21', 'bd8968db-ad2a-4dd0-a0ab-7eebcc05427e',
        '48a95af7-8b83-4a08-8001-0f865db8ea11', 'briedis eina laukais', '2020-10-16');

INSERT INTO users_roles(user_id, roles_id)
VALUES ('c2aa5f20-2441-40f8-8cce-d31dbd17bc84', '60dbb7bb-99a0-42eb-a837-8be6b697c074'),
       ('bd8968db-ad2a-4dd0-a0ab-7eebcc05427e', '60dbb7bb-99a0-42eb-a837-8be6b697c074'),
       ('bd8968db-ad2a-4dd0-a0ab-7eebcc05427e', '3906c549-44bf-494b-9537-5e1658a029a8');

INSERT INTO blogs_comments(blog_id, comments_id)
VALUES ('48a95af7-8b83-4a08-8001-0f865db8ea10', '48a95af7-8b83-4a08-8001-0f865db8ea20'),
       ('48a95af7-8b83-4a08-8001-0f865db8ea10', '48a95af7-8b83-4a08-8001-0f865db8ea21');


