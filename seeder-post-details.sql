USE blog_db;
insert into posts(title, body, owner_user_id) values ('Title', 'uybuy', 1);
insert into post_details(is_awesome, topic_description) values ('Pink', '˙ɐnbᴉlɐ ɐuƃɐɯ ǝɹolop ʇǝ ǝɹoqɐl ʇn ʇunpᴉpᴉɔuᴉ ɹodɯǝʇ poɯsnᴉǝ op pǝs ''ʇᴉlǝ ƃuᴉɔsᴉdᴉpɐ ɹnʇǝʇɔǝsuoɔ ''ʇǝɯɐ ʇᴉs ɹolop ɯnsdᴉ ɯǝɹo˥', 1, 1, '8:01 AM', false, '7 Series');


# One-to-One Mini Exercise:
# 0. Checkout out to a new clean branch called ‘relationship-practice’ in your Spring Blog.
# 1. Add a PostDetails entity with the following fields:
#   id (typical primary key annotations)
#   isAwesome boolean
#   historyOfPost TEXT
#   topicDescription VARCHAR(255)
# 2. Add the needed annotation to map the one-to-one relationship between Post and PostDetails.
# 3. Seed a couple of entries into the PostDetails and Posts table
# 4. Add a GetMapping method to the PostController that returns a simple view that displays a given post’s historyOfPost detail.
# If you have time, build out a create post page that includes fields that are stored in the post details and work on post creation
# that also create the post details associated with it.