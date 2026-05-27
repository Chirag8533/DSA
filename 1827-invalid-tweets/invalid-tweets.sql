# Write your MySQL query statement below
select tweet_id from Tweets 
where length(content)>15
/*Why Does It Work?

Because in this problem:

tweets contain normal English characters
each character usually takes 1 byte

So:

LENGTH(content)

and

CHAR_LENGTH(content)

give same result.

Difference Between Them
Function	Counts
LENGTH()	Bytes
CHAR_LENGTH()	Characters
Example

Suppose:

"hello"

Each character = 1 byte

So:

LENGTH('hello') = 5
CHAR_LENGTH('hello') = 5

Both same.

When Difference Happens

With Unicode characters/emojis.

Example:

"😊"

Now:

LENGTH('😊') = 4
CHAR_LENGTH('😊') = 1

Because:

emoji uses multiple bytes
but still one character
*/