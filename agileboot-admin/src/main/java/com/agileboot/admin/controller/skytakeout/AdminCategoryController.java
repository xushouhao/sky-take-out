package com.agileboot.admin.controller.skytakeout;


import com.agileboot.common.core.dto.ResponseDTO;
import com.agileboot.common.core.page.PageDTO;
import com.agileboot.domain.skytakeout.category.CategoryApplicationService;
import com.agileboot.domain.skytakeout.category.command.AddCategoryCommand;
import com.agileboot.domain.skytakeout.category.command.UpdateCategoryCommand;
import com.agileboot.domain.skytakeout.category.dto.CategoryDTO;
import com.agileboot.domain.skytakeout.category.query.CategoryQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "分类API", description = "分类请求相关接口")
@RestController
@RequiredArgsConstructor
@RequestMapping("admin/category")
public class AdminCategoryController {
    private final CategoryApplicationService applicationService;

    /**
     * 获取分类列表
     *
     * @return 分类列表
     */
    @Operation(summary = "获取分类列表", description = "获取分类列表")
    @GetMapping("/list")
    public ResponseDTO<PageDTO<CategoryDTO>> listCategories(CategoryQuery query) {
        PageDTO<CategoryDTO> page = applicationService.getlist(query);
        return ResponseDTO.ok(page);
    }

    /**
     * 新增分类
     */
    @Operation(summary = "新增分类", description = "新增分类")
    @PostMapping
    public ResponseDTO<Void> addCategory(@RequestBody AddCategoryCommand command) {
        applicationService.addCategory(command);
        return ResponseDTO.ok();
    }

    /**
     * 删除分类
     */
    @Operation(summary = "删除分类", description = "删除分类")
    @DeleteMapping("/{id}")
    public ResponseDTO<Void> deleteCategory(@PathVariable Integer id) {
        applicationService.deleteCategory(id);
        return ResponseDTO.ok();
    }

    /**
     * 根据 id 查询分类信息
     */
    @Operation(summary = "根据 id 查询分类信息", description = "根据 id 查询分类信息")
    @GetMapping("/{id}")
    public ResponseDTO<CategoryDTO> getCategoryById(@PathVariable Integer id) {
        CategoryDTO category = applicationService.getCategoryById(id);
        return ResponseDTO.ok(category);
    }

    /**
     * 更新分类信息
     */
    @Operation(summary = "更新分类信息", description = "更新分类信息")
    @PutMapping
    public ResponseDTO<Void> updateCategory(@RequestBody UpdateCategoryCommand command) {
        applicationService.updateCategory(command);
        return ResponseDTO.ok();
    }

    /**
     * 启用或禁用分类
     */
    @Operation(summary = "启用或禁用分类", description = "启用或禁用分类")
    @PutMapping("/status/{id}")
    public ResponseDTO<Void> updateCategoryStatus(@PathVariable Integer id, @RequestParam Integer status) {
        applicationService.updateCategoryStatus(id, status);
        return ResponseDTO.ok();
    }

}
