override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus){
            val location=  IntArray(2)
            //testImage.getLocationOnScreen(location)
            println(location)
            ly_inferior.getLocationOnScreen(location)
            println(location)
            val background = (parent_layout_macroactivity_list.background as BitmapDrawable).bitmap
            val croppedBack = Bitmap.createBitmap(background, 0, ((location[1]*background.height )/parent_layout_macroactivity_list.height)-50,
                    background.getWidth(), 100)

            val targetBitmap = Bitmap.createBitmap(croppedBack.width, croppedBack.height, Bitmap.Config.ARGB_8888)

            val paint = Paint(Paint.ANTI_ALIAS_FLAG)
            paint.color = resources.getColor(R.color.season_shape)

            val canvas = Canvas(targetBitmap)
            val path = Path()
            path.moveTo(200f,0f)
            path.lineTo(550f,0f)
            path.lineTo(600f,100f)
            path.lineTo(150f,100f)

            canvas.drawPath(path,paint)
            paint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.SRC_IN ));
            canvas.drawBitmap(croppedBack, 0f, 0f, paint)
            testImage.setImageBitmap(targetBitmap)
        }
    }
